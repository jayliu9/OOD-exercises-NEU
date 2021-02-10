package problem1;

/**
 * Represents a gardening service. GardeningService is the subclass of AbstractNonspecialist.
 */
public class GardeningService extends AbstractNonspecialist {

  private static final double WASTE_REMOVAL_FEE = 20.0;

  /**
   * Constructor for the GardeningService class
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   */
  public GardeningService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices) {
    super(propertyAddress, size, isMonthly, numOfServices);
  }

  /**
   * Calculates the extra charge for the gardening service.
   * @param basePrice The base price.
   * @return The extra charge is waste removal fee, which is fixed.
   */
  @Override
  protected double extraCharge(double basePrice) {
    return WASTE_REMOVAL_FEE;
  }

  /**
   * Creates a string representation of the GardeningService.
   * @return a string representation of the GardeningService.
   */
  @Override
  public String toString() {
    return "GardeningService: " + super.toString();
  }
}
