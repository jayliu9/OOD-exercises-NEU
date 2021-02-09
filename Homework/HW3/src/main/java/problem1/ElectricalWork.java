package problem1;

public class ElectricalWork extends AbstractSpecialist {

  private static final double PERMITTING_FEE_OF_ELECTRICAL = 50;
  private static final int MAX_NUMBER_OF_EMPLOYEE = 4;

  public ElectricalWork(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfEmployee, boolean isComplex) throws InvalidNumOfEmployees {
    super(propertyAddress, size, isMonthly, numOfServices, numOfEmployee, isComplex);

  }

  @Override
  protected double extraCharge(double price) {
    return PERMITTING_FEE_OF_ELECTRICAL;
  }

  @Override
  protected int validateEmployee(int numOfEmployee) throws InvalidNumOfEmployees {
    if (numOfEmployee > MAX_NUMBER_OF_EMPLOYEE) {
      throw new InvalidNumOfEmployees("Too much employees!");
    }
    return super.validateEmployee(numOfEmployee);
  }
}
