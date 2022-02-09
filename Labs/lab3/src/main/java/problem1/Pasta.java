package problem1;

/**
 * Represents pasta, The Pasta class is the subclass of NonperishableFood.
 */
public class Pasta extends NonperishableFood {

  /**
   * Constructor for the pasta.
   * @param name The name of the pasta
   * @param pricePerUnit The current price per unit of the pasta.
   * @param availableQuantity The current available quantity of the pasta
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   */
  public Pasta(String name, Double pricePerUnit, Integer availableQuantity)
      throws StorageExcessException {
    super(name, pricePerUnit, availableQuantity);
  }
}
