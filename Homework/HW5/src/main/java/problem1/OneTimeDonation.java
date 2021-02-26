package problem1;

/**
 * Represent a one-time donation. OneTimeDonation is the subclass of AbstractDonation
 */
import java.time.LocalDateTime;

public class OneTimeDonation extends AbstractDonation {

  /**
   * Constructor for the OneTimeDonation class
   * @param amount The amount of the one-time donation
   * @param creationTime The date and time that the one-time donation was made
   */
  public OneTimeDonation(long amount, LocalDateTime creationTime) {
    super(amount, creationTime);
  }

  /**
   * Checks if the donation has been processed in the particular year or not.
   * @param year The given year
   * @return true if the donation has been processed in the particular year, false otherwise
   */
  @Override
  protected boolean isProcessedInYear(int year) {
    return this.getCreationTime().getYear() == year;
  }

  /**
   * Gets the amount of the donation processed in the specified year.
   * @param year The year
   * @return The amount of the donation processed in the specified year.
   */
  @Override
  public long getAmountForYear(int year) {
    if (isProcessedInYear(year)) {
      return this.getAmount();
    }
    return 0;
  }

  /**
   * Creates a string representation of the OneTimeDonation.
   * @return a string representation of the OneTimeDonation.
   */
  @Override
  public String toString() {
    return "OneTimeDonation{" +
        "amount=" + this.getAmount() +
        ", creationTime=" + this.getCreationTime() +
        '}';
  }
}
