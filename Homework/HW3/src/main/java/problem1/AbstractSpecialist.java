package problem1;

import java.util.Objects;

/**
 * Abstract class representing common fields and behaviors of a specialist property service.
 */
public abstract class AbstractSpecialist extends AbstractPropertyService {

  private int numOfEmployee;
  private boolean isComplex;
  private static final int MIN_NUM_OF_PEOPLE = 1;
  private static final int EMPLOYEES_FOR_COMPLEX_LARGE = 3;
  private static final int EMPLOYEES_FOR_COMPLEX_SMALL_AND_MEDIUM = 2;
  private static final int HIRE_PRICE = 200;

  /**
   * Constructor for the AbstractSpecialist class.
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
  public AbstractSpecialist(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfEmployee, boolean isComplex) throws InvalidNumOfEmployees {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.isComplex = isComplex;
    this.numOfEmployee = this.validateEmployee(numOfEmployee);
  }

  /**
   * Helper function that ensures that the minimum requirement of the number of employees is met.
   * If the requirement is not met, the minimum requirement of the number of employees will be
   * returned.
   * @param numOfEmployee The number of employees of the specialist property service
   * @return The number of employees of the specialist property service if the minimum requirement
   * is met, otherwise the minimum requirement.
   * @throws InvalidNumOfEmployees if the specialist property service is electrical service which
   * requires more than 4 licensed employees.
   */
  protected int validateEmployee(int numOfEmployee) throws InvalidNumOfEmployees {
    int minEmployee = this.calculateMinimum();
    if (numOfEmployee < minEmployee) {
      return minEmployee;
    }
    return numOfEmployee;
  }

  /**
   * Helper function that calculates the minimum requirement of the number of employees based on
   * whether or not the work is complex and the property size if the work is complex.
   * @return the minimum requirement of the number of employees.
   */
  private int calculateMinimum() {
    int minimum = MIN_NUM_OF_PEOPLE;
    if (this.isComplex) {
      minimum = this.calculateMinInput();
    }
    return minimum;
  }

  /**
   * Calculates the base price of the service based on specified rules
   * @return The base price of the service
   */
  @Override
  public int calculateBasePrice() {
    return HIRE_PRICE * this.numOfEmployee;
  }

  /**
   * Helper function that calculates the minimum required employees according to the property size
   * if the work is complex.
   * @return The minimum required employees according to the property size if the work is complex.
   */
  @Override
  protected int calculateMinInput() {
    switch (this.getSize()) {
      case SMALL:
      case MEDIUM:
        return EMPLOYEES_FOR_COMPLEX_SMALL_AND_MEDIUM;
      default:
        return EMPLOYEES_FOR_COMPLEX_LARGE;
    }
  }

  /**
   * Calculates the amount off due to discount.
   * @param price The charge in total for the service
   * @return The amount off due to discount. The discount should not be applied to specialist
   * services, so 0.0 is returned.
   */
  @Override
  protected double calculateDiscount(double price) {
    return 0.0;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    AbstractSpecialist that = (AbstractSpecialist) o;
    return this.numOfEmployee == that.numOfEmployee && this.isComplex == that.isComplex;
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfEmployee, this.isComplex);
  }

  /**
   * Creates a string representation of the AbstractSpecialist.
   * @return a string representation of the AbstractSpecialist.
   */
  @Override
  public String toString() {
    return super.toString() + ", numOfEmployee = " + this.numOfEmployee
        + ", isComplex = " + this.isComplex;
  }

  /**
   * Gets the number of employees
   * @return The number of employees
   */
  public int getNumOfEmployee() {
    return this.numOfEmployee;
  }

  /**
   * Checks if the specialist property service is complex.
   * @return true the specialist property service is complex, false otherwise.
   */
  public boolean isComplex() {
    return this.isComplex;
  }
}