package problem1;

/**
 * Represents fruit, The Fruit class is the subclass of PerishableFood.
 */
public class Fruit extends PerishableFood {

  /**
   * Constructor for the fruit.
   * @param name The name of the fruit
   * @param pricePerUnit The current price per unit of the fruit.
   * @param availableQuantity The current available quantity of the fruit
   * @param orderDate The order date of the fruit, representing the number of days since
   *                  May 15, 2021
   * @param expirationDate The expiration date of the fruit, representing
   *                       the number of days since May 15, 2021
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   * @throws SpoilageException if the order date is greater than the expiration date.
   */
  public Fruit(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}
