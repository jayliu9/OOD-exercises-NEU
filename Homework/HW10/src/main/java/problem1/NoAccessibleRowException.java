package problem1;

public class NoAccessibleRowException extends Exception {

  public NoAccessibleRowException() {
    super("Theater must contain at least one accessible row");
  }
}
