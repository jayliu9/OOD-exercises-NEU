package problem1;

public class InvalidInputException extends Exception {

  public InvalidInputException() {
    super("Invalid input, please try again!");
  }
}
