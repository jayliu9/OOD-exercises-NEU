package problem1;

public class InvalidNumOfSeatsException extends Exception {

  public InvalidNumOfSeatsException() {
    super("The number of seats to reserve should be larger than 0");
  }
}
