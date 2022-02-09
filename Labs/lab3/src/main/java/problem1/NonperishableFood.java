package problem1;

/**
 * Represents a non-perishable food item, whose maximum allowed quantity is 250. This class is
 * the subclass of Food.
 */
public class NonperishableFood extends Food {

  private static final Integer MAXIMUM = 250;

  /**
   * Constructor that creates a new nonperishableFood class. Its maximum allowed quantity is set
   * to 250
   * @param name The name of the non-perishable food
   * @param pricePerUnit The current price per unit of the non-perishable food
   * @param availableQuantity The current available quantity of the non-perishable food
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   */
  public NonperishableFood(String name, Double pricePerUnit, Integer availableQuantity)
      throws StorageExcessException {
    super(name, pricePerUnit, availableQuantity, MAXIMUM);
  }
}
