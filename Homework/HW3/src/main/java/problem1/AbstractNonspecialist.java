package problem1;

public abstract class AbstractNonspecialist extends AbstractPropertyService {
  private static final int HOURLY_PAY = 80;
  private static final int HOURS_FOR_SMALL = 1;
  private static final int HOURS_FOR_MEDIUM = 2;
  private static final int HOURS_FOR_LARGE = 4;
  private static final int DISCOUNT_REQUIREMENT = 10;
  private static final double HALF = 0.5;
  private static final double TEN_PERCENT_DISCOUNT = 0.1;

  public AbstractNonspecialist(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices) {
    super(propertyAddress, size, isMonthly, numOfServices);
  }

  @Override
  public int calculateBaseRate() {
    int workingHours = this.calculateMinInput();
    return workingHours * HOURLY_PAY;
  }

  @Override
  protected int calculateMinInput() {
    switch (this.getSize()) {
      case SMALL:
        return HOURS_FOR_SMALL;
      case MEDIUM:
        return HOURS_FOR_MEDIUM;
      default:
        return HOURS_FOR_LARGE;
    }
  }

  protected double calculateDiscount(double priceOfService) {
    if (this.shouldHalfDiscount()) {
      return priceOfService * HALF;
    } else if (this.isMonthly()) {
      return priceOfService * TEN_PERCENT_DISCOUNT;
    }
    return 0.0;
  }

  private boolean shouldHalfDiscount() {
    return this.getNumOfServices() % DISCOUNT_REQUIREMENT == 9;
  }
}
