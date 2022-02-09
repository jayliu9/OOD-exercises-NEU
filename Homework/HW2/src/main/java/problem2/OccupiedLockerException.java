package problem2;

public class OccupiedLockerException extends Exception {

  public OccupiedLockerException() {
    super("This locker is occupied already!");
  }
}
