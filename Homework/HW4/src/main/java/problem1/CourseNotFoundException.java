package problem1;

public class CourseNotFoundException extends Exception {

  public CourseNotFoundException() {
    super("The course is not found!");
  }
}
