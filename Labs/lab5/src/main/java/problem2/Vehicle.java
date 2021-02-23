package problem2;

import java.util.Objects;

/**
 * Represents a vehicle.
 */
public class Vehicle {

  private String iD;
  private Float averageSpeed;
  private Float maxSpeed;

  /**
   * Constructor for the Vehicle class.
   * @param iD The ID of the vehicle
   * @param averageSpeed The average speed of the vehicle
   * @param maxSpeed The max speed of the vehicle
   */
  public Vehicle(String iD, Float averageSpeed, Float maxSpeed) {
    this.iD = iD;
    this.averageSpeed = averageSpeed;
    this.maxSpeed = maxSpeed;
  }

  /**
   * Gets the ID of the vehicle.
   * @return The ID of the vehicle.
   */
  public String getID() {
    return this.iD;
  }

  /**
   * Gets the average speed of the vehicle
   * @return The average speed of the vehicle
   */
  public Float getAverageSpeed() {
    return this.averageSpeed;
  }

  /**
   * Gets the max speed of the vehicle
   * @return The max speed of the vehicle.
   */
  public Float getMaxSpeed() {
    return this.maxSpeed;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return this.iD.equals(vehicle.iD) && this.averageSpeed.equals(vehicle.averageSpeed) &&
        this.maxSpeed.equals(vehicle.maxSpeed);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.iD, this.averageSpeed, this.maxSpeed);
  }

  /**
   * Creates a string representation of the Vehicle.
   * @return a string representation of the Vehicle.
   */
  @Override
  public String toString() {
    return "ID=" + this.iD +
        ", averageSpeed=" + this.averageSpeed +
        ", maxSpeed=" + this.maxSpeed +
        '}';
  }
}
