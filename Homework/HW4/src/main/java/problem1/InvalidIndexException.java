package problem1;

public class InvalidIndexException extends Exception {

  public InvalidIndexException() {
    super("The index is invalid!");
  }
}
