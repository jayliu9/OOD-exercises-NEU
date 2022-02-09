package problem1;

/**
 * Represents rice, The Rice class is the subclass of NonperishableFood.
 */
public class Rice extends NonperishableFood {

  /**
   * Constructor for the rice.
   * @param name The name of the rice
   * @param pricePerUnit The current price per unit of the rice.
   * @param availableQuantity The current available quantity of the rice
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   */
  public Rice(String name, Double pricePerUnit, Integer availableQuantity)
      throws StorageExcessException {
    super(name, pricePerUnit, availableQuantity);
  }
}
