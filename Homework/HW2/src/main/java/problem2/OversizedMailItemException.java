package problem2;

public class OversizedMailItemException extends Exception {

  public OversizedMailItemException() {
    super("This mail item exceeds the dimensions of this locker!");
  }
}
