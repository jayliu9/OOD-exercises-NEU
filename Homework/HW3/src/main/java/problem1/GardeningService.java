package problem1;

public class GardeningService extends AbstractNonspecialist {
  private static final double WASTE_REMOVAL_FEE = 20.0;

  public GardeningService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices) {
    super(propertyAddress, size, isMonthly, numOfServices);
  }

  @Override
  protected double extraCharge(double price) {
    return WASTE_REMOVAL_FEE;
  }
}
