package problem1;

public class Fruit extends PerishableFood {

  public Fruit(String name, Double pricePerUnit, Integer availableQuantity,
      Integer orderDate, Integer expirationDate) throws StorageExcessException, SpoilageException {
    super(name, pricePerUnit, availableQuantity, orderDate, expirationDate);
  }
}
