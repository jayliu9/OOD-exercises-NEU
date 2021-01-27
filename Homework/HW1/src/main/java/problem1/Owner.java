package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * Owner is an object that has a first name, last name and a phone number.
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private static final String DEFAULT_PHONE_NUMBER = "0000000000";
    private static final int REQUIRED_LENGTH = 10;

    /**
     * Constructor that creates a new Owner object with the specified first name and
     * last name and phone number.
     * @param firstName The first name of this Owner.
     * @param lastName The last name of this Owner.
     * @param phoneNumber This Owner's phone number, which must consist of 10 characters.
     */
    public Owner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = this.validatePhoneNum(phoneNumber);
    }

    /**
     * Helper method that ensures the phone number is valid. If the phone number is invalid, the default phone number is
     * returned. The default phone number is 0000000000
     * @param phoneNum The phone number to validate
     * @return The validated phone number if the phone number is valid. Otherwise the default phone number.
     */
    private String validatePhoneNum(String phoneNum) {
        if (phoneNum.length() == REQUIRED_LENGTH) {
            return phoneNum;
        } else {
            return DEFAULT_PHONE_NUMBER;
        }
    }

    /**
     * Returns the first name of this Owner
     * @return The first name of this Owner
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of this Owner
     * @return The last name of this Owner
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the phone number of this Owner
     * @return The phone number of this Owner
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Sets the first name of this Owner.
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of this Owner.
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the phone number of this Owner.
     * @param phoneNumber The new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
