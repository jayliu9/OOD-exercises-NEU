package problem2;

import java.util.Objects;

public class IndividualPerson implements Creator {

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  @Override
  public boolean isExactMatch(Creator person) {
    return this.equals(person);
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }
}
