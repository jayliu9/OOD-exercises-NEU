package problem1;

public interface ICourseCatalog {

  /**
   * Adds a course to the end of the course catalog.
   * @param course The course to add
   */
  void append(Course course);

  /**
   * Removes a specified course from the course catalog
   * @param course The course to remove
   * @throws CourseNotFoundException if the course does not exist
   */
  void remove(Course course) throws CourseNotFoundException;

  /**
   * Checks if the specified course exists in the course catalog.
   * @param course The course to check
   * @return true if the course exist in the course catalog, false otherwise.
   */
  boolean contains(Course course);

  /**
   * Returns the index of the specified course in the course catalog.
   * @param course The course
   * @return The index of the course if it exists. If it does not exist, return -1.
   */
  int indexOf(Course course);

  /**
   * Gets the number of courses in the course catalog.
   * @return The number of courses in the course catalog.
   */
  int count();

  /**
   * Returns the course at the given index in the course catalog.
   * @param index The index to search
   * @return The course at the index
   * @throws InvalidIndexException if the index does not exist.
   */
  Course get(int index) throws InvalidIndexException;

  /**
   * Checks if the course catalog is empty
   * @return
   */
  boolean isEmpty();
}
