package problem1;

public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private static final String DEFAULT_PHONE_NUMBER = "0000000000";
    private static final int REQUIRED_LENGTH = 10;

    public Owner(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = this.validatePhoneNum(phoneNumber);
    }

    private String validatePhoneNum(String phoneNum) {
        if (phoneNum.length() == REQUIRED_LENGTH) {
            return phoneNum;
        } else {
            return DEFAULT_PHONE_NUMBER;
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
