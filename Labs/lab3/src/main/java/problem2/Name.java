package problem2;

import java.util.Objects;

/**
 * Represents a name. Includes the first name and the last name.
 */
public class Name {

  private String firstName;
  private String lastName;

  /**
   * Constructor for the Name class
   * @param firstName The first name of the name
   * @param lastName The last name of the name
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
   * {@inheritDoc}
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


  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }
}
