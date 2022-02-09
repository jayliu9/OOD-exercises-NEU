package problem1;

/**
 * Represents meat, The Meat class is the subclass of PerishableFood.
 */
public class Meat extends PerishableFood {

  /**
   * Constructor for the meat.
   * @param name The name of the meat
   * @param pricePerUnit The current price per unit of the meat.
   * @param availableQuantity The current available quantity of the meat
   * @param orderDate The order date of the meat, representing the number of days since
   *                  May 15, 2021
   * @param expirationDate The expiration date of the meat, representing
   *                       the number of days since May 15, 2021
   * @throws StorageExcessException if the current available quantity exceeds the maximum allowed
   * quantity of the food.
   * @throws SpoilageException if the order date is greater than the expiration date.
   */
  public Meat(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}
