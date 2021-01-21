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
        return firstName;
    }

    /**
     * Gets the last name of this person
     * @return the first name of this person
     */
    public String getLastName() {
        return lastName;
    }
}
