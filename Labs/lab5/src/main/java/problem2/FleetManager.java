package problem2;

/**
 * Represents a fleet manager.
 */
public class FleetManager {

  /**
   * Constructor for the FleetManager class.
   */
  public FleetManager() {
  }

  /**
   * Populates the fields of a TripReport.
   * @param distance The distance of a trip.
   * @param vehicle The vehicle that took the trip.
   * @return a new TripReport object for any type of Vehicle.
   */
  TripReport drive(float distance, Vehicle vehicle) {
    Float speed = vehicle.getAverageSpeed();
    Integer duration = (int) Math.ceil(distance / speed);
    return new TripReport(vehicle, speed, distance, duration);
  }

  /**
   * Populates the fields of a TripReport.
   * @param vehicle The vehicle that took the trip
   * @param duration The trip duration
   * @return a new TripReport object for any type of Vehicle.
   */
  TripReport drive(Vehicle vehicle, int duration) {
    Float speed = vehicle.getAverageSpeed();
    Float distance = speed * duration;
    return new TripReport(vehicle, speed, distance, duration);
  }

  /**
   * Populates the fields of a TripReport.
   * @param vehicle The vehicle that took the trip
   * @param speed The speed of the vehicle on this trip
   * @param distance The distance of this trip
   * @return a new TripReport object for any type of Vehicle.
   */
  TripReport drive(Vehicle vehicle, float speed, float distance) {
    Float checkedSpeed = this.validateSpeed(vehicle, speed);
    Integer duration = (int) Math.ceil(distance / checkedSpeed);
    return new TripReport(vehicle, checkedSpeed, distance, duration);
  }

  /**
   * Populates the fields of a TripReport
   * @param vehicle The vehicle that took the trip
   * @param speed The speed of the vehicle on this trip
   * @param duration The trip duration
   * @return a new TripReport object for any type of Vehicle.
   */
  TripReport drive(Vehicle vehicle, float speed, int duration) {
    Float checkedSpeed = this.validateSpeed(vehicle, speed);
    Float distance = duration * checkedSpeed;
    return new TripReport(vehicle, checkedSpeed, distance, duration);
  }

  /**
   * Helper function that checks that the given speed is within the vehicle's max speed.
   * @param vehicle The vehicle to check
   * @param speed The speed to check
   * @return The validated speed if the speed is within the vehicle's max speed. If the speed
   * exceeds the vehicle's max speed, return the max speed.
   */
  private float validateSpeed(Vehicle vehicle, float speed) {
    if (speed > vehicle.getMaxSpeed()) {
      return vehicle.getMaxSpeed();
    }
    return speed;
  }
}
