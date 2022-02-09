package problem2;

public class MismatchedRecipientException extends Exception {

  public MismatchedRecipientException() {
    super("Recipients mismatch!");
  }
}
