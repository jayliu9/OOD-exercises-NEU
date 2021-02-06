package problem1;

public class Food implements FoodItem {

  private String name;
  private Double pricePerUnit;
  private Integer availableQuantity;
  private final Integer MAX;

  public Food(String name, Double pricePerUnit, Integer availableQuantity, Integer MAX)
      throws StorageExcessException {
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.MAX = MAX;
    this.validateStorage(availableQuantity);
    this.availableQuantity = availableQuantity;
  }

  public String getName() {
    return this.name;
  }

  public Double getPricePerUnit() {
    return this.pricePerUnit;
  }

  public Integer getAvailableQuantity() {
    return this.availableQuantity;
  }

  private void validateStorage(Integer availableQuantity) throws StorageExcessException {
    if (availableQuantity > this.MAX) {
      throw new StorageExcessException();
    }
  }
}
