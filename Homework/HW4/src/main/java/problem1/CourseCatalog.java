package problem1;

import java.util.Objects;

/**
 * Represents a CourseCatalog ADT, which is implemented using the array as the underlying data
 * structure.
 */
public class CourseCatalog implements ICourseCatalog {

  private Course[] courses;
  private int numOfCourses;
  private static final int DEFAULT_NUM_OF_SLOTS = 5;
  private static final int COURSE_NOT_EXIST = -1;
  private String a;

  /**
   * Constructor for the CourseCatalog class. Initializes the CourseCatalog object with no courses
   * and with a course array with the default number of slots
   */
  public CourseCatalog() {
    this.courses = new Course[DEFAULT_NUM_OF_SLOTS];
    this.numOfCourses = 0;
  }

  /**
   * Adds a course to the end of the course catalog.
   * @param course The course to add
   */
  @Override
  public void append(Course course) {
    if (this.overLength()) {
      this.resize();
    }
    this.courses[this.numOfCourses] = course;
    this.numOfCourses++;
  }

  /**
   * Increases the size of the data array.
   */
  private void resize() {
    int newSize = this.courses.length + DEFAULT_NUM_OF_SLOTS;
    Course[] newList = new Course[newSize];
    this.copyArray(this.courses, newList);
    this.courses = newList;
  }

  /**
   * Helper function that copies the whole of the "from" array to the "to" array.
   * @param from The array to copy from
   * @param to The array to copy to
   */
  private void copyArray(Course[] from, Course[] to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }

  /**
   * Helper function that checks if there is no room in the data array to add a new item.
   * @return true if there is no room to add a new item, false otherwise
   */
  private boolean overLength() {
    return this.numOfCourses + 1 > this.courses.length;
  }

  /**
   * Removes a specified course from the course catalog
   * @param course The course to remove
   * @throws CourseNotFoundException if the course does not exist
   */
  @Override
  public void remove(Course course) throws CourseNotFoundException {
    int indexToRemove = this.indexOf(course);
    boolean isFound = indexToRemove != COURSE_NOT_EXIST;
    if (!isFound) {
      throw new CourseNotFoundException();
    } else {
      this.shiftDown(this.courses, indexToRemove + 1);
      this.numOfCourses--;
    }
  }

  /**
   * Helper function that moves down all the items after a given index (inclusive) by 1.
   * @param array The array in which the items are going to be moved
   * @param startIndex The starting index to move the items from
   */
  private void shiftDown(Course[] array, int startIndex) {
    for (int i = startIndex; i < this.numOfCourses; i++) {
      array[i - 1] = array[i];
    }
  }

  /**
   * Checks if the specified course exists in the course catalog.
   * @param course The course to check
   * @return true if the course exist in the course catalog, false otherwise.
   */
  @Override
  public boolean contains(Course course) {
    if (this.indexOf(course) == COURSE_NOT_EXIST) {
      return false;
    }
    return true;
  }

  /**
   * Returns the index of the specified course in the course catalog.
   * @param course The course
   * @return The index of the course if it exists. If it does not exist, return -1.
   */
  @Override
  public int indexOf(Course course) {
    for (int i = 0; i < this.numOfCourses; i++) {
      if (course.equals(this.courses[i])) {
        return i;
      }
    }
    return COURSE_NOT_EXIST;
  }

  /**
   * Gets the number of courses in the course catalog.
   * @return The number of courses in the course catalog.
   */
  @Override
  public int count() {
    return this.numOfCourses;
  }

  /**
   * Returns the course at the given index in the course catalog.
   * @param index The index to search
   * @return The course at the index
   * @throws InvalidIndexException if the index does not exist.
   */
  @Override
  public Course get(int index) throws InvalidIndexException {
    this.checkBoundary(index);
    return this.courses[index];
  }

  /**
   * Checks that the given index is in the valid boundary.
   * @param index The index to check
   * @throws InvalidIndexException if the index does not exist
   */
  private void checkBoundary(int index) throws InvalidIndexException {
    if (index < 0 || index >= this.numOfCourses) {
      throw new InvalidIndexException();
    }
  }

  /**
   * Checks if the course catalog is empty
   * @return true if the course catalog is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return this.numOfCourses == 0;
  }

  /**
   * Helper function that checks if this array of courses have the same courses as the given array
   * of courses. Null items are excluded.
   * @param that The array of courses to compared to
   * @return true if both arrays contain the same courses in the same order, false otherwise.
   */
  private boolean sameCourses(Course[] that) {
    for(int i = 0; i < this.numOfCourses; i++) {
      if(!this.courses[i].equals(that[i])) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseCatalog that = (CourseCatalog) o;
    return this.numOfCourses == that.numOfCourses && this.sameCourses(that.courses);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(this.numOfCourses);
    result = 31 * result;
    for (int i = 0; i < this.numOfCourses; i++) {
      result += 31 * Objects.hash(this.courses[i]);
    }
    return result;
  }

  /**
   * Creates a string representation of the CourseCatalog
   * @return a string representation of the CourseCatalog.
   */
  @Override
  public String toString() {
    String stringOfCourses = "";
    for (int i = 0; i < this.numOfCourses; i++) {
      stringOfCourses += this.courses[i].toString() + ", ";
    }
    if (!this.isEmpty()) {
      stringOfCourses = stringOfCourses.substring(0, stringOfCourses.length() - ", ".length());
    }
    return "CourseCatalog: " +
        "numOfCourses = " + this.numOfCourses +
        ", courses = {" + stringOfCourses + "}";
  }
}
