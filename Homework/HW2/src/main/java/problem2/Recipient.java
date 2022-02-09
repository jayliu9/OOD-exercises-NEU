package problem2;

import java.util.Objects;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents Recipient with the first name, last name, and email address.
 */
public class Recipient {

  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * Constructor for the Recipient class.
   * @param firstName The recipient's first name, a String.
   * @param lastName The recipient's last name, a String.
   * @param emailAddress The recipient's email address, a String.
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    if (!Objects.equals(this.firstName, recipient.firstName)) {
      return false;
    }
    if (!Objects.equals(this.lastName, recipient.lastName)) {
      return false;
    }
    return Objects.equals(this.emailAddress, recipient.emailAddress);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = this.firstName != null ? this.firstName.hashCode() : 0;
    result = 31 * result + (this.lastName != null ? this.lastName.hashCode() : 0);
    result = 31 * result + (this.emailAddress != null ? this.emailAddress.hashCode() : 0);
    return result;
  }

  /**
   * Gets the first name of this Recipient.
   * @return The first name of this Recipient.
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the last name of this Recipient.
   * @return The last name of this Recipient.
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Gets the email address of this Recipient.
   * @return The email address of this Recipient.
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }
}
