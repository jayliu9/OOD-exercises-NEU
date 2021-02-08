package problem1;

import com.sun.org.apache.xpath.internal.operations.Minus;

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
    this.numOfEmployee = this.validateEmployee(numOfEmployee);
    this.isComplex = isComplex;
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
        return this.EMPLOYEES_FOR_COMPLEX_SMALL_AND_MEDIUM;
      default:
        return this.EMPLOYEES_FOR_COMPLEX_LARGE;
    }
  }

  @Override
  protected double calculateDiscount(double price) {
    return 0.0;
  }
}