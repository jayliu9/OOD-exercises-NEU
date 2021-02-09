package problem1;

public class PlumbingWork extends AbstractSpecialist {
  private static final double PERMITTING_FEE_OF_PLUMBING = 20.0;

  public PlumbingWork(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfEmployee, boolean isComplex) throws InvalidNumOfEmployees {
    super(propertyAddress, size, isMonthly, numOfServices, numOfEmployee, isComplex);
  }

  @Override
  protected double extraCharge(double price) {
    return PERMITTING_FEE_OF_PLUMBING;
  }

  /**
   * Creates a string representation of the AbstractSpecialist.
   *
   * @return a string representation of the AbstractSpecialist.
   */
  @Override
  public String toString() {
    return "PlumbingWork: " + super.toString();
  }
}
