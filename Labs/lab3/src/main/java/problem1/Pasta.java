package problem1;

public class Pasta extends NonperishableFood {

  public Pasta(String name, Double pricePerUnit, Integer availableQuantity)
      throws StorageExcessException {
    super(name, pricePerUnit, availableQuantity);
  }
}
