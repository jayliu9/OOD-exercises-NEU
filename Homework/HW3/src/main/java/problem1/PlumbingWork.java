package problem1;

/**
 * Represents an plumbing work. PlumbingWork is the subclass of AbstractSpecialist.
 */
public class PlumbingWork extends AbstractSpecialist {

  private static final double PERMITTING_FEE_OF_PLUMBING = 20.0;

  /**
   * Constructor for the PlumbingWork class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   * @param numOfEmployee The number of licensed employees required to complete the work,
   *                     represented as an integer.
   * @param isComplex a boolean that indicates if the work to be done is complex.
   * @throws InvalidNumOfEmployees if the specialist property service is electrical service which
   * requires more than 4 licensed employees.
   */
  public PlumbingWork(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfEmployee, boolean isComplex) throws InvalidNumOfEmployees {
    super(propertyAddress, size, isMonthly, numOfServices, numOfEmployee, isComplex);
  }

  /**
   * Calculates the extra charge for the plumbing work.
   * @param basePrice The base price.
   * @return The extra charge is permitting fee of $20, which is fixed.
   */
  @Override
  protected double extraCharge(double basePrice) {
    return PERMITTING_FEE_OF_PLUMBING;
  }

  /**
   * Creates a string representation of the PlumbingWork.
   * @return a string representation of the PlumbingWork.
   */
  @Override
  public String toString() {
    return "PlumbingWork: " + super.toString();
  }
}
