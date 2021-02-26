package problem1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Represent a monthly donation. MonthlyDonation is the subclass of AbstractDonation
 */
public class MonthlyDonation extends AbstractDonation {

  private LocalDateTime cancellationTime;
  private static final int MONTH_IN_YEAR = 12;

  /**
   * Constructor for the MonthlyDonation class. It has no cancellation date/time when created.
   * @param amount The amount of the monthly donation.
   * @param creationTime The date and time that the monthly donation was made
   */
  public MonthlyDonation(long amount, LocalDateTime creationTime) {
    super(amount, creationTime);
    this.cancellationTime = null;
  }

  /**
   * Checks whether or not the monthly donation have no cancellation date/time.
   * @return true if the monthly donation have no cancellation date/time, false otherwise.
   */
  private boolean isNullCancellationTime() {
    return this.cancellationTime == null;
  }

  /**
   * Checks if the donation has been processed in the particular year or not.
   * @param year The given year
   * @return true if the donation has been processed in the particular year, false otherwise
   */
  @Override
  protected boolean isProcessedInYear(int year) {
    int yearOfCreation = this.getCreationTime().getYear();
    int yearOfCancellation = this.cancellationTime.getYear();
    if (yearOfCreation > year || (!this.isNullCancellationTime() && yearOfCancellation < year)) {
      return false;
    }
    return true;
  }

  /**
   * Helper function that gets the number of months between a starting date/time and a end date/time
   * @param start The starting date/time.
   * @param end The end date/time
   * @return The number of months from a starting date/time to a end date/time.
   */
  private long getNumberOfMonths(LocalDateTime start, LocalDateTime end) {
    return start.until(end, ChronoUnit.MONTHS);
  }

  /**
   * Helper function that gets the number of months between a starting date/time to
   * the end of the same year.
   * @param start The starting date/time
   * @return The number of months between a starting date/time to the end of the same year.
   */
  private long getNumberOfMonths(LocalDateTime start) {
    return MONTH_IN_YEAR - start.getMonthValue();
  }

  /**
   * Gets the amount of the donation processed in the specified year.
   * @param year The year
   * @return The amount of the donation processed in the specified year.
   */
  @Override
  public long getAmountForYear(int year) {
    if (!isProcessedInYear(year)) {
      return 0;
    }
    int yearOfCancellation = this.cancellationTime.getYear();
    long numOfActiveMonths =
        (this.isNullCancellationTime() || yearOfCancellation > year) ?
        this.getNumberOfMonths(this.getCreationTime()) :
        this.getNumberOfMonths(this.getCreationTime(), this.cancellationTime);
    return (numOfActiveMonths + 1) * this.getAmount();
  }

  /**
   * Checks that the proposed cancellation is not prior to the creation date and time
   * @param cancellationTime The cancellation date and time
   * @throws InvalidTimeException if the proposed cancellation is prior to
   * the creation date and time
   */
  private void checkOrderOfCancellationTime(LocalDateTime cancellationTime)
      throws InvalidTimeException {
    if (cancellationTime.isBefore(this.getCreationTime())) {
      throw new InvalidTimeException("Cancellation prior to creation!");
    }
  }

  /**
   * Sets the cancellation date and time.
   * @param cancellationTime The cancellation date and time.
   * @throws InvalidTimeException if the proposed cancellation is prior to
   * the creation date and time
   */
  public void setCancellationTime(LocalDateTime cancellationTime) throws InvalidTimeException {
    this.checkOrderOfCancellationTime(cancellationTime);
    this.cancellationTime = cancellationTime;
  }

  /**
   * Gets the cancellation date and time of the monthly donation
   * @return The cancellation date and time of the monthly donation.
   * @throws NoAvailableTimeException if the cancellation date and time is not set.
   */
  public LocalDateTime getCancellationTime() throws NoAvailableTimeException {
    this.checkNonnullCancellationTime();
    return this.cancellationTime;
  }

  /**
   * Checks that the cancellation date and time have been set.
   * @throws NoAvailableTimeException if the cancellation date and time is not set.
   */
  private void checkNonnullCancellationTime() throws NoAvailableTimeException {
    if (this.cancellationTime == null) {
      throw new NoAvailableTimeException();
    }
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    MonthlyDonation that = (MonthlyDonation) o;
    return Objects.equals(this.cancellationTime, that.cancellationTime);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.cancellationTime);
  }

  /**
   * Creates a string representation of the MonthlyDonation.
   * @return a string representation of the MonthlyDonation.
   */
  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "amount=" + this.getAmount() +
        ", creationTime=" + this.getCreationTime() +
        ", cancellationTime=" + this.cancellationTime +
        '}';
  }
}
