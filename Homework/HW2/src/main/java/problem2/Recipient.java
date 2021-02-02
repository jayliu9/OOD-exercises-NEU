package problem2;

import java.util.Objects;

public class Recipient {
  private String firstName;
  private String lastName;
  private String emailAddress;

  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || this.getClass() != object.getClass()) {
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

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }
}
