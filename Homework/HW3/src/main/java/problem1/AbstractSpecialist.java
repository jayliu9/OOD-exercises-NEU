package problem1;

import java.util.Objects;

public abstract class AbstractSpecialist extends AbstractPropertyService {

  private int numOfEmployee;
  private boolean isComplex;
  private static final int MIN_NUM_OF_PEOPLE = 1;
  private static final int EMPLOYEES_FOR_COMPLEX_LARGE = 3;
  private static final int EMPLOYEES_FOR_COMPLEX_SMALL_AND_MEDIUM = 2;
  private static final int HIRE_PRICE = 200;

  public AbstractSpecialist(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfEmployee, boolean isComplex) throws InvalidNumOfEmployees {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.isComplex = isComplex;
    this.numOfEmployee = this.validateEmployee(numOfEmployee);
  }

  protected int validateEmployee(int numOfEmployee) throws InvalidNumOfEmployees {
    int minEmployee = this.calculateMinimum();
    if (numOfEmployee < minEmployee) {
      return minEmployee;
    }
    return numOfEmployee;
  }

  private int calculateMinimum() {
    int minimum = MIN_NUM_OF_PEOPLE;
    if (this.isComplex) {
      minimum = this.calculateMinInput();
    }
    return minimum;
  }

  @Override
  public int calculateBaseRate() {
    return HIRE_PRICE * this.numOfEmployee;
  }

  @Override
  protected int calculateMinInput() {
    switch(this.getSize()) {
      case SMALL:
      case MEDIUM:
        return EMPLOYEES_FOR_COMPLEX_SMALL_AND_MEDIUM;
      default:
        return EMPLOYEES_FOR_COMPLEX_LARGE;
    }
  }

  @Override
  protected double calculateDiscount(double price) {
    return 0.0;
  }


  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    AbstractSpecialist that = (AbstractSpecialist) o;
    return this.numOfEmployee == that.numOfEmployee && this.isComplex == that.isComplex;
  }

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

  public int getNumOfEmployee() {
    return this.numOfEmployee;
  }

  public boolean isComplex() {
    return this.isComplex;
  }
}