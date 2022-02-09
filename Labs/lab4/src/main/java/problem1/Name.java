package problem1;

import java.util.Objects;

/**
 * Represents a name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructor for the Name class
   * @param firstName The first name
   * @param lastName The last name
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name
   * @return The first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the last name
   * @return The last name
   */
  public String getLastName() {
    return this.lastName;
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
    Name name = (Name) o;
    return this.firstName.equals(name.firstName) && this.lastName.equals(name.lastName);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }
}
