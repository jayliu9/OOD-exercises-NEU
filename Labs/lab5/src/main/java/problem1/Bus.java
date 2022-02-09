package problem1;

/**
 * Represents a bus. The Bus is the subclass of the Vehicle.
 */
public class Bus extends Vehicle {

  /**
   * Constructor for the Bus class.
   * @param iD The ID of the bus
   * @param averageSpeed The average speed of the bus
   * @param maxSpeed The max speed of the bus
   */
  public Bus(String iD, Float averageSpeed, Float maxSpeed) {
    super(iD, averageSpeed, maxSpeed);
  }

  /**
   * Creates a string representation of the Bus.
   * @return a string representation of the Bus.
   */
  @Override
  public String toString() {
    return "Bus{" + super.toString();
  }
}
