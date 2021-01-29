package problem1;

/**
 * problem1.Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5005
 * Course Number: 38135
 * Semester: Spring 2021
 *
 * This class represents a name with a first name and a last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructs a new problem1.Name object and initializes it with the given first name and last name
   * @param firstName The first name of this problem1.Name
   * @param lastName The last name of this problem1.Name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Returns the first name of this problem1.Name
   * @return The first name of this problem1.Name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Sets the first name of this problem1.Name
   * @param firstName The new first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Returns the last name of this problem1.Name
   * @return The last name of this problem1.Name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Sets the last name of this problem1.Name
   * @param lastName The new last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
