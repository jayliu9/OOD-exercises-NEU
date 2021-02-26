package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Abstract class representing common fields and behaviors of a donation.
 */
public abstract class AbstractDonation implements Donation {

  private long amount;
  private LocalDateTime creationTime;

  /**
   * Constructor for the AbstractDonation class
   * @param amount The amount of the donation
   * @param creationTime The date and time that the donation was made
   */
  protected AbstractDonation(long amount, LocalDateTime creationTime) {
    this.amount = amount;
    this.creationTime = creationTime;
  }

  /**
   * Checks if the donation has been processed in the particular year or not.
   * @param year The given year
   * @return true if the donation has been processed in the particular year, false otherwise
   */
  protected abstract boolean isProcessedInYear(int year);

  /**
   * Gets the amount of the donation
   * @return The amount of the donation
   */
  public long getAmount() {
    return this.amount;
  }

  /**
   * Gets the creation date and time of the donation
   * @return The creation date and time of the donation
   */
  public LocalDateTime getCreationTime() {
    return this.creationTime;
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
    AbstractDonation that = (AbstractDonation) o;
    return this.amount == that.amount && Objects.equals(this.creationTime, that.creationTime);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.amount, this.creationTime);
  }
}
