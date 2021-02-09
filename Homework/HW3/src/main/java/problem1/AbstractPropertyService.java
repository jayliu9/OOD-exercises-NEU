package problem1;

import java.util.HashMap;
import java.util.Objects;

public abstract class AbstractPropertyService implements PropertyService {

  private String propertyAddress;
  private PropertySize size;
  private boolean isMonthly;
  private int numOfServices;

  public AbstractPropertyService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices) {
    this.propertyAddress = propertyAddress;
    this.size = size;
    this.isMonthly = isMonthly;
    this.numOfServices = numOfServices;
  }

  protected abstract int calculateMinInput();

  protected abstract double extraCharge(double price);

  protected abstract double calculateDiscount(double price);

  public String getPropertyAddress() {
    return this.propertyAddress;
  }

  public PropertySize getSize() {
    return this.size;
  }

  public boolean isMonthly() {
    return this.isMonthly;
  }

  public int getNumOfServices() {
    return this.numOfServices;
  }

  @Override
  public double calculatePrice() {
    int baseRate = this.calculateBaseRate();
    double extraCharge = this.extraCharge(baseRate);
    double totalCost = baseRate + extraCharge;
    double discount = this.calculateDiscount(totalCost);
    return totalCost - discount;
  }

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
