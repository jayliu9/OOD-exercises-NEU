/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5005
 * Course Number: 38135
 * Semester: Spring 2021
 *
 * This class represents a person. The person has a first name and a last name.
 *
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a Person object and initializes it with the given first name and last name
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name of this person
     * @return the first name of this person
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of this person
     * @return the last name of this person
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the first name of this person
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of this person
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
