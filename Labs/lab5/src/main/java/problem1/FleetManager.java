package problem1;

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
}
