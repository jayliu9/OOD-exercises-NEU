package problem2;

public class InvalidItemRemovalException extends Exception {

  public InvalidItemRemovalException() {
    super("The item to remove does not exist!");
  }
}
