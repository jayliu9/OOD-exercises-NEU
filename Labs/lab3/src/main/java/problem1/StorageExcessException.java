package problem1;

public class StorageExcessException extends Exception {

  public StorageExcessException() {
    super("Storage exceeds maximum!");
  }
}
