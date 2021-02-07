package problem2;

import java.util.Objects;

public class Name {

  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

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
