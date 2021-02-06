package problem1;

public class NonperishableFood extends Food {

  private static final Integer MAXIMUM = 250;

  public NonperishableFood(String name, Double pricePerUnit, Integer availableQuantity)
      throws StorageExcessException {
    super(name, pricePerUnit, availableQuantity, MAXIMUM);
  }

}
