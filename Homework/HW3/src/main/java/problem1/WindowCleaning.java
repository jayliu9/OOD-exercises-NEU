package problem1;

import java.util.Objects;

public class WindowCleaning extends AbstractNonspecialist {
  private int numOfFloor;
  private static int MAX_FLOOR = 3;
  private static int RATE_OF_EXTRA_CHARGE = 5;

  public WindowCleaning(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfFloor) throws InvalidFloorException {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.validateNumOfFloor(numOfFloor);
    this.numOfFloor = numOfFloor;
  }

  private void validateNumOfFloor(int numOfFloor) throws InvalidFloorException {
    if (numOfFloor > MAX_FLOOR) {
      throw new InvalidFloorException();
    }
  }

  @Override
  protected double extraCharge(double price) {
    if (this.numOfFloor > 1) {
      return price * RATE_OF_EXTRA_CHARGE;
    }
    return 0.0;
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    WindowCleaning that = (WindowCleaning) o;
    return this.numOfFloor == that.numOfFloor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfFloor);
  }

  /**
   * Creates a string representation of the AbstractPropertyService.
   * @return a string representation of the AbstractPropertyService.
   */
  @Override
  public String toString() {
    return "WindowCleaning: " + super.toString() + ", numOfFloor = " + this.numOfFloor;
  }
}
