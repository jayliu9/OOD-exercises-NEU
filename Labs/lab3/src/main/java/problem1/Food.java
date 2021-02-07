package problem1;

/**
 * Represents a food item, including the name, current price per unit, current available
 * quantity and maximum allowed quantity.
 */
public class Food implements FoodItem {

  private String name;
  private Double pricePerUnit;
  private Integer availableQuantity;
  private final Integer max;

  /**
   * Constructor for Food class.
   * @param name The name of the food, represented as a String
   * @param pricePerUnit The current price per unit of the food, represented as a Double
   * @param availableQuantity The current available quantity of the food, represented as an Integer
   * @param max The maximum allowed quantity of the food, which is a constant represented
   *            as an Integer.
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   */
  public Food(String name, Double pricePerUnit, Integer availableQuantity, Integer max)
      throws StorageExcessException {
    this.name = name;
    this.pricePerUnit = pricePerUnit;
    this.max = max;
    this.validateStorage(availableQuantity);
    this.availableQuantity = availableQuantity;
  }

  /**
   * Gets the name of the food
   * @return The name of the food
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the current price per unit of the food
   * @return The current price per unit
   */
  public Double getPricePerUnit() {
    return this.pricePerUnit;
  }

  /**
   * Gets the current available quantity of the food
   * @return The current available quantity
   */
  public Integer getAvailableQuantity() {
    return this.availableQuantity;
  }

  /**
   * Gets the maximum allowed quantity of the food
   * @return The maximum allowed quantity.
   */
  public Integer getMax() {
    return this.max;
  }

  /**
   * Checks that the current available quantity is not greater than the maximum allowed quantity.
   * @param availableQuantity The current available quantity.
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity.
   */
  private void validateStorage(Integer availableQuantity) throws StorageExcessException {
    if (availableQuantity > this.max) {
      throw new StorageExcessException();
    }
  }
}
