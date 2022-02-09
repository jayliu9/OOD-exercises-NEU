package problem2;

import java.util.Objects;

/**
 * Represents an individual person. IndividualPerson is an implementation of Creator
 */
public class IndividualPerson implements Creator {

  private String firstName;
  private String lastName;

  /**
   * Constructor for the IndividualPerson class
   * @param firstName The first name of the individual person
   * @param lastName The last name of the individual person
   */
  public IndividualPerson(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name of the individual person
   * @return The first name of the individual person
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the last name of the individual person
   * @return The last name of the individual person
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Checks if the particular person is the exact match for the creator
   * @param person The person to check
   * @return true if the person to check is the exact match for the creator, false otherwise
   */
  @Override
  public boolean isExactMatch(Creator person) {
    return this.equals(person);
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualPerson that = (IndividualPerson) o;
    return this.firstName.equals(that.firstName) && this.lastName.equals(that.lastName);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }

  /**
   * Creates a string representation of the IndividualPerson.
   * @return a string representation of the IndividualPerson.
   */
  @Override
  public String toString() {
    return "IndividualPerson{" +
        "firstName='" + this.firstName + '\'' +
        ", lastName='" + this.lastName + '\'' +
        '}';
  }
}
