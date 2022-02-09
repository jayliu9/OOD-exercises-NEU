package problem2;

public class NoMailItemException extends Exception {

  public NoMailItemException() {
    super("No mail item in the locker!");
  }
}
