package problem1;

/**
 * Abstract class representing common fields and behaviors of a non-specialist property service.
 */
public abstract class AbstractNonspecialist extends AbstractPropertyService {

  private static final int HOURLY_PAY = 80;
  private static final int HOURS_FOR_SMALL = 1;
  private static final int HOURS_FOR_MEDIUM = 2;
  private static final int HOURS_FOR_LARGE = 4;
  private static final int DISCOUNT_REQUIREMENT = 10;
  private static final double HALF = 0.5;
  private static final double TEN_PERCENT_DISCOUNT = 0.1;

  /**
   * Constructor for the AbstractNonspecialist class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   */
  public AbstractNonspecialist(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices) {
    super(propertyAddress, size, isMonthly, numOfServices);
  }

  /**
   * Calculates the base price of the service based on specified rules
   * @return The base price of the service
   */
  @Override
  public int calculateBasePrice() {
    int workingHours = this.calculateMinInput();
    return workingHours * HOURLY_PAY;
  }

  /**
   * Calculates the hours required to complete the non-specialist service according to the property
   * size.
   * @return the required hours.
   */
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

  /**
   * Calculates the amount off due to discount.
   * @param price The charge in total for the non-specialist service
   * @return The amount off due to discount.
   */
  protected double calculateDiscount(double price) {
    if (this.shouldHalfDiscount()) {
      return price * HALF;
    } else if (this.isMonthly()) {
      return price * TEN_PERCENT_DISCOUNT;
    }
    return 0.0;
  }

  /**
   * Checks if a 50% discount should be applied.
   * @return true if a 50% discount should be applied, false otherwise.
   */
  private boolean shouldHalfDiscount() {
    return this.getNumOfServices() % DISCOUNT_REQUIREMENT == 9;
  }
}
