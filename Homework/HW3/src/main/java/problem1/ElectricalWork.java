package problem1;

/**
 * Represents an electrical work. ElectricalWork is the subclass of AbstractSpecialist.
 */
public class ElectricalWork extends AbstractSpecialist {

  private static final double PERMITTING_FEE_OF_ELECTRICAL = 50;
  private static final int MAX_NUMBER_OF_EMPLOYEE = 4;

  /**
   * Constructor for the ElectricalWork class
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   * @param numOfEmployee The number of licensed employees required to complete the work,
   *                     represented as an integer.
   * @param isComplex a boolean that indicates if the work to be done is complex.
   * @throws InvalidNumOfEmployees if the electrical service requires more than 4 licensed employees
   */
  public ElectricalWork(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfEmployee, boolean isComplex) throws InvalidNumOfEmployees {
    super(propertyAddress, size, isMonthly, numOfServices, numOfEmployee, isComplex);
  }

  /**
   * Calculates the extra charge for the electrical work.
   * @param basePrice The base price.
   * @return The extra charge is permitting fee of $50, which is fixed.
   */
  @Override
  protected double extraCharge(double basePrice) {
    return PERMITTING_FEE_OF_ELECTRICAL;
  }

  /**
   * Checks that the number of employees required to complete electrical work is between
   * the minimum requirement and the maximum requirement.
   * @param numOfEmployee The number of employees of the electrical work
   * @return The number of employees of the electrical work if the minimum requirement is met,
   * otherwise the minimum requirement.
   * @throws InvalidNumOfEmployees if the electrical service requires more than 4 licensed employees
   */
  @Override
  protected int validateEmployee(int numOfEmployee) throws InvalidNumOfEmployees {
    if (numOfEmployee > MAX_NUMBER_OF_EMPLOYEE) {
      throw new InvalidNumOfEmployees("Too much employees!");
    }
    return super.validateEmployee(numOfEmployee);
  }

  /**
   * Creates a string representation of the ElectricalWork.
   * @return a string representation of the ElectricalWork.
   */
  @Override
  public String toString() {
    return "ElectricalWork: " + super.toString();
  }
}
