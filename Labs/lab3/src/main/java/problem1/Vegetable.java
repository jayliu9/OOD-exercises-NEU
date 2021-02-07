package problem1;

/**
 * Represents vegetable, The Vegetable class is the subclass of PerishableFood.
 */
public class Vegetable extends PerishableFood {

  /**
   * Constructor for the vegetable.
   * @param name The name of the vegetable
   * @param pricePerUnit The current price per unit of the vegetable.
   * @param availableQuantity The current available quantity of the vegetable
   * @param orderDate The order date of the vegetable, representing the number of days since
   *                  May 15, 2021
   * @param expirationDate The expiration date of the vegetable, representing
   *                       the number of days since May 15, 2021
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   * @throws SpoilageException if the order date is greater than the expiration date.
   */
  public Vegetable(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}
