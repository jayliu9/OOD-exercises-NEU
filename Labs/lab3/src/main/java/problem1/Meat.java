package problem1;

public class Meat extends PerishableFood {

  public Meat(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}
