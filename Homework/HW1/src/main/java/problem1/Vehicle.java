package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * Vehicle is a simple object that has a unique Vehicle Identification Number
 * (VIN), corresponding license plate and an Owner.
 */
public class Vehicle {
    private Integer VIN;
    private String licensePlate;
    private Owner vehicleOwner;
    /**
     * Constructor that creates a new vehicle object with the specified VIN and
     * license plate.
     * @param VIN - VIN of the new Vehicle object.
     * @param licensePlate - license plate of the new Vehicle.
     * @param vehicleOwner - owner of the new Vehicle.
     */
    public Vehicle(Integer VIN, String licensePlate, Owner vehicleOwner) {
        this.VIN = VIN;
        this.licensePlate = licensePlate;
        this.vehicleOwner = vehicleOwner;
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
     * Returns the Owner of the Vehicle.
     * @return the Owner of the Vehicle.
     */
    public Owner getVehicleOwner() {
        return this.vehicleOwner;
    }
    /**
     * Sets the VIN of the Vehicle.
     * @param VIN - the new VIN.
     */

    public void setVIN(Integer VIN) {
        this.VIN = VIN;
    }
    /**
     * Sets the licensePlate of the Vehicle.
     * @param licensePlate - the new license plate.
     *
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    /**
     * Sets the Owner of the Vehicle.
     * @param vehicleOwner - the new Owner.
     */
    public void setVehicleOwner(Owner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }
}
