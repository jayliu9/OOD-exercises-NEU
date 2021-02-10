package problem1;

import java.util.Objects;

/**
 * Represents a window cleaning. WindowCleaning is the subclass of AbstractNonspecialist.
 */
public class WindowCleaning extends AbstractNonspecialist {

  private int numOfFloor;
  private static final int MAX_FLOOR = 3;
  private static final double RATE_OF_EXTRA_CHARGE = 0.05;

  /**
   * Constructor for the WindowCleaning class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   * @param numOfFloor The number of floors the property has, represented as an integer.
   * @throws InvalidFloorException if the number of floors is more than 3.
   */
  public WindowCleaning(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfFloor) throws InvalidFloorException {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.validateNumOfFloor(numOfFloor);
    this.numOfFloor = numOfFloor;
  }

  /**
   * Checks that the maximum number of floors that the company works with is 3.
   * @param numOfFloor The number of floors the property has
   * @throws InvalidFloorException if the number of floors is more than 3.
   */
  private void validateNumOfFloor(int numOfFloor) throws InvalidFloorException {
    if (numOfFloor > MAX_FLOOR) {
      throw new InvalidFloorException();
    }
  }

  /**
   * Calculates the extra charge for the window cleaning based on the number of floors.
   * @param basePrice The base price.
   * @return The extra charge for the window cleaning.
   */
  @Override
  protected double extraCharge(double basePrice) {
    if (this.numOfFloor > 1) {
      return basePrice * RATE_OF_EXTRA_CHARGE;
    }
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
    WindowCleaning that = (WindowCleaning) o;
    return this.numOfFloor == that.numOfFloor;
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfFloor);
  }

  /**
   * Creates a string representation of the WindowCleaning.
   * @return a string representation of the WindowCleaning.
   */
  @Override
  public String toString() {
    return "WindowCleaning: " + super.toString() + ", numOfFloor = " + this.numOfFloor;
  }

  /**
   * Gets the number of floors the property has.
   * @return The number of floors.
   */
  public int getNumOfFloor() {
    return this.numOfFloor;
  }
}
