package problem2;

import java.util.Objects;

public class Recipient {
  private String firstName;
  private String lastName;
  private String emailAddress;


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (this.getClass() != object.getClass() || object == null) {
      return false;
    }
    Recipient recipient = (Recipient) object;
    if (!Objects.equals(this.firstName, recipient.firstName)) {
      return false;
    }
    if (!Objects.equals(this.lastName, recipient.lastName)) {
      return false;
    }
    return Objects.equals(this.emailAddress, recipient.emailAddress);
  }

  @Override
  public int hashCode() {
    int result = this.firstName != null ? this.firstName.hashCode() : 0;
    result = 31 * result + (this.lastName != null ? this.lastName.hashCode() : 0);
    result = 31 * result + (this.emailAddress != null ? this.emailAddress.hashCode() : 0);
    return result;
  }
}
