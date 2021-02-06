package problem1;

public class PerishableFood extends Food {

  private static final Integer MAXIMUM = 100;
  private Integer orderDate;
  private Integer expirationDate;

  public PerishableFood(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, MAXIMUM);
    this.validateFoodSafety(orderDate, expirationDate);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  private void validateFoodSafety(Integer orderDate, Integer expirationDate)
      throws SpoilageException {
    if (orderDate > expirationDate) {
      throw new SpoilageException();
    }
  }

  public Integer getOrderDate() {
    return this.orderDate;
  }

  public Integer getExpirationDate() {
    return this.expirationDate;
  }

}
