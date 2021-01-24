package problem1;

/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number
 (VIN), and corresponding license plate.
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

    public Owner getVehicleOwner() {
        return this.vehicleOwner;
    }

    /**
     * Forms the full name using the given first name and last name.
     * @param firstName the given first name
     * @param lastName the given last name
     * @return the full name.

    private String formFullName(String firstName, String lastName) {
        String WHITESPACE = " ";
        return firstName + WHITESPACE + lastName;
    }

    /**
     * Returns the Owner's name of this Vehicle
     * @return the Owner's name of this Vehicle

    public String getOwnerName() {
        return this.formFullName(this.vehicleOwner.getFirstName(), this.vehicleOwner.getLastName());
    }

    /**
     * Returns the Owner's phone number of this Vehicle
     * @return the Owner's phone number of this Vehicle

    public String getOwnerPhoneNum() {
        return this.vehicleOwner.getPhoneNumber();
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

    public void setVehicleOwner(Owner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }
}
