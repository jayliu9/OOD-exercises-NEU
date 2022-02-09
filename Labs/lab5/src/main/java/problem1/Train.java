package problem1;

/**
 * Represents a train. The train is the subclass of the Vehicle.
 */
public class Train extends Vehicle {

  /**
   * Constructor for the Train class.
   * @param iD The ID of the train
   * @param averageSpeed The average speed of the train
   * @param maxSpeed The max speed of the train
   */
  public Train(String iD, Float averageSpeed, Float maxSpeed) {
    super(iD, averageSpeed, maxSpeed);
  }

  /**
   * Creates a string representation of the Train.
   * @return a string representation of the Train.
   */
  @Override
  public String toString() {
    return "Train{" + super.toString();
  }
}
