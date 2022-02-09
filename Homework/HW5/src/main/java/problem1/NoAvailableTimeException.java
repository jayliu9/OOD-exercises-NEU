package problem1;

public class NoAvailableTimeException extends Exception {

  public NoAvailableTimeException() {
    super("No date/time to process!");
  }
}
