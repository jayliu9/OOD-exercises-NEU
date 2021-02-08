package problem1;

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
}
