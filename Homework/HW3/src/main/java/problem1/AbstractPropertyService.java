package problem1;

import java.util.HashMap;
import java.util.Objects;

/**
 * Abstract class representing common fields and behaviors of a property service.
 */
public abstract class AbstractPropertyService implements PropertyService {

  private String propertyAddress;
  private PropertySize size;
  private boolean isMonthly;
  private int numOfServices;

  /**
   * Constructor for the AbstractPropertyService class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   */
  public AbstractPropertyService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices) {
    this.propertyAddress = propertyAddress;
    this.size = size;
    this.isMonthly = isMonthly;
    this.numOfServices = numOfServices;
  }

  /**
   * Calculates the minimum requirement (hours or employees) according to the property size.
   * @return the minimum requirement (hours or employees)
   */
  protected abstract int calculateMinInput();

  /**
   * Calculates the extra charge based on specific rules.
   * @param basePrice The base price.
   * @return The extra charge of the service.
   */
  protected abstract double extraCharge(double basePrice);

  /**
   * Calculates the amount off due to discount.
   * @param price The charge in total for the service
   * @return The amount off due to discount.
   */
  protected abstract double calculateDiscount(double price);

  /**
   * Gets the property address.
   * @return The property address.
   */
  public String getPropertyAddress() {
    return this.propertyAddress;
  }

  /**
   * Gets the property size.
   * @return The property size.
   */
  public PropertySize getSize() {
    return this.size;
  }

  /**
   * Checks if the service is carried out monthly.
   * @return true if the service is carried out monthly, false otherwise.
   */
  public boolean isMonthly() {
    return this.isMonthly;
  }

  /**
   * Gets the number of the services previously carried out at the address.
   * @return The number of the services previously carried out at the address.
   */
  public int getNumOfServices() {
    return this.numOfServices;
  }

  /**
   * Calculates the total price of the service based on specified rules
   * @return The total price of the service
   */
  @Override
  public double calculatePrice() {
    int basePrice = this.calculateBasePrice();
    double extraCharge = this.extraCharge(basePrice);
    double totalCost = basePrice + extraCharge;
    double discount = this.calculateDiscount(totalCost);
    return totalCost - discount;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractPropertyService that = (AbstractPropertyService) o;
    return this.isMonthly == that.isMonthly && this.numOfServices == that.numOfServices
        && this.propertyAddress.equals(that.propertyAddress) && this.size == that.size;
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.propertyAddress, this.size, this.isMonthly, this.numOfServices);
  }

  /**
   * Creates a string representation of the AbstractPropertyService.
   * @return a string representation of the AbstractPropertyService.
   */

  @Override
  public String toString() {
    return "propertyAddress = " + this.propertyAddress +
        ", size = " + this.size +
        ", isMonthly = " + this.isMonthly +
        ", numOfServices = " + this.numOfServices;
  }
}
