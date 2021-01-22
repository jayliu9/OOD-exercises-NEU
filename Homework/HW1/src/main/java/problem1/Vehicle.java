package problem1;

/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number
 (VIN), and corresponding license plate.
 */
public class Vehicle {
    private Integer VIN;
    private String licensePlate;
    /**
     * Constructor that creates a new vehicle object with the specified VIN and
     * license plate.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     */
    public Vehicle(Integer VIN, String licensePlate) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
    }
    /**
     * Returns the VIN of the Vehicle.
     * @return the VIN of the Vehicle.
     */
    public Integer getVIN() {
        return this.VIN;
    }
    /**
     * Returns the licensePlate of the Vehicle.
     * @return the licensePlate of the Vehicle.
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }
    /**
     * Sets the VIN of the Vehicle.
     */
    public void setVIN(Integer VIN) {
        this.VIN = VIN;
    }
    /**
     * Sets the licensePlate of the Vehicle.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
