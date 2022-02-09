package problem2;

import java.util.Objects;

/**
 * Represents a trip report.
 */
public class TripReport {

  private Vehicle vehicle;
  private Float speed;
  private Float distance;
  private Integer duration;

  /**
   * Constructor for the TripReport class
   * @param vehicle Vehicle that took the trip
   * @param speed Speed in miles per minute, a Float
   * @param distance Distance traveled in miles, a Float
   * @param duration Trip duration in minutes, an Integer
   */
  public TripReport(Vehicle vehicle, Float speed, Float distance, Integer duration) {
    this.vehicle = vehicle;
    this.speed = speed;
    this.distance = distance;
    this.duration = duration;
  }

  /**
   * Gets the vehicle that took the trip.
   * @return The vehicle that took the trip
   */
  public Vehicle getVehicle() {
    return this.vehicle;
  }

  /**
   * Gets the speed of the trip
   * @return The speed of the trip
   */
  public Float getSpeed() {
    return this.speed;
  }

  /**
   * Gets the distance of the trip
   * @return The distance of the trip
   */
  public Float getDistance() {
    return this.distance;
  }

  /**
   * Gets the duration of the trip
   * @return The duration of the trip.
   */
  public Integer getDuration() {
    return this.duration;
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
    TripReport that = (TripReport) o;
    return this.vehicle.equals(that.vehicle) && this.distance.equals(that.distance) &&
        this.speed.equals(that.speed);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.vehicle, this.speed, this.duration);
  }

  /**
   * Creates a string representation of the TripReport.
   * @return a string representation of the TripReport.
   */
  @Override
  public String toString() {
    return "TripReport{" +
        "vehicle=" + this.vehicle +
        ", speed=" + this.speed +
        ", distance=" + this.distance +
        ", duration=" + this.duration +
        '}';
  }
}
