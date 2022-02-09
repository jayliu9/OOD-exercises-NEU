package problem1;

public class NotEnoughSeatsException extends Exception {

  public NotEnoughSeatsException() {
    super("Sorry, we don't have that many seats together for you.");
  }
}
