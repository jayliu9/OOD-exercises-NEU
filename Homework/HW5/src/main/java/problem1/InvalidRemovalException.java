package problem1;

public class InvalidRemovalException extends Exception {

  public InvalidRemovalException() {
    super("The donation to remove does not exist!");
  }
}
