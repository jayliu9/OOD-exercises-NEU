package problem1;

public class Rice extends NonperishableFood {

  public Rice(String name, Double pricePerUnit, Integer availableQuantity)
      throws StorageExcessException {
    super(name, pricePerUnit, availableQuantity);
  }
}
