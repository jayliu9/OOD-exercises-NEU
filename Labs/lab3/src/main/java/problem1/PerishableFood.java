package problem1;

/**
 * Represents a perishable food item, whose maximum allowed quantity is 100. This class is
 * the subclass of Food.
 */
public class PerishableFood extends Food {

  private static final Integer MAXIMUM = 100;
  private Integer orderDate;
  private Integer expirationDate;

  /**
   * Constructor that creates a new perishableFood class. Its maximum allowed quantity is set
   * to 100
   * @param name The name of the perishable food.
   * @param pricePerUnit The current price per unit of the perishable food.
   * @param availableQuantity The current available quantity of the perishable food
   * @param orderDate The order date of the perishable food, representing the number of days since
   *                  May 15, 2021
   * @param expirationDate The expiration date of the perishable food, representing
   *                       the number of days since May 15, 2021
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   * @throws SpoilageException if the order date is greater than the expiration date.
   */
  public PerishableFood(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, MAXIMUM);
    this.validateFoodSafety(orderDate, expirationDate);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Checks that this perishable food has not gone bad.
   * @param orderDate The order date of the perishable food, representing the number of days
   *                  since May 15, 2021
   * @param expirationDate The expiration date of the perishable food, representing
   *                       the number of days since May 15, 2021
   * @throws SpoilageException if the order date is greater than the expiration date.
   */
  private void validateFoodSafety(Integer orderDate, Integer expirationDate)
      throws SpoilageException {
    if (orderDate > expirationDate) {
      throw new SpoilageException();
    }
  }

  /**
   * Gets the order date of the perishable food.
   * @return The order date of the perishable food.
   */
  public Integer getOrderDate() {
    return this.orderDate;
  }

  /**
   * Gets the expiration date of the perishable food.
   * @return The expiration date of the perishable food.
   */
  public Integer getExpirationDate() {
    return this.expirationDate;
  }
}
