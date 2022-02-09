package problem1;

/**
 * Represents a boat. The Boat is the subclass of the Vehicle.
 */
public class Boat extends Vehicle {

  /**
   * Constructor for the Boat class.
   * @param iD The ID of the boat
   * @param averageSpeed The average speed of the boat
   * @param maxSpeed The max speed of the boat
   */
  public Boat(String iD, Float averageSpeed, Float maxSpeed) {
    super(iD, averageSpeed, maxSpeed);
  }

  /**
   * Creates a string representation of the Boat.
   * @return a string representation of the Boat.
   */
  @Override
  public String toString() {
    return "Boat{" + super.toString();
  }
}
