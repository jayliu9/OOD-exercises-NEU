package problem1;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represent a pledge. Pledge is the subclass of AbstractDonation
 */
public class Pledge extends AbstractDonation {

  private LocalDateTime processingTime;

  /**
   * Constructor for the Pledge class.
   * @param amount The amount in the pledge
   * @param creationTime The creation time of the pledge
   */
  public Pledge(long amount, LocalDateTime creationTime) {
    super(amount, creationTime);
    this.processingTime = null;
  }

  /**
   * Constructor for the Pledge class
   * @param amount The given amount of the pledge to donate at some point in the future.
   * @param creationTime The creation date and time of the pledge
   * @param processingTime The processing date and time of the donation in the pledge.
   * @throws InvalidTimeException if proposed processing date and time is prior to the creation
   * date and time.
   */
  public Pledge(long amount, LocalDateTime creationTime, LocalDateTime processingTime)
      throws InvalidTimeException {
    super(amount, creationTime);
    this.checkOrderOfProcessTime(processingTime);
    this.processingTime = processingTime;
  }

  /**
   * Checks that the processing date and time is not prior to the creation date and time
   * @param processingTime The processing date and time to check
   * @throws InvalidTimeException if proposed processing date and time is prior to the creation
   * date and time.
   */
  private void checkOrderOfProcessTime(LocalDateTime processingTime)
      throws InvalidTimeException {
    if (processingTime.isBefore(this.getCreationTime())) {
      throw new InvalidTimeException("Processing time is prior to creation time!");
    }
  }

  /**
   * Checks whether or not the pledge have no processing date/time.
   * @return true if the pledge have no processing date/time, false otherwise.
   */
  private boolean isNullProcessingTime() {
    return this.processingTime == null;
  }

  /**
   * Checks if the donation has been processed in the particular year or not.
   * @param year The given year
   * @return true if the donation has been processed in the particular year, false otherwise
   */
  @Override
  protected boolean isProcessedInYear(int year) {
    return this.processingTime.getYear() == year;
  }

  /**
   * Gets the amount of the donation processed in the specified year.
   * @param year The year
   * @return The amount of the donation processed in the specified year.
   */
  @Override
  public long getAmountForYear(int year) {
    if (!this.isNullProcessingTime() && this.isProcessedInYear(year)) {
      return this.getAmount();
    }
    return 0;
  }

  /**
   * Sets the processing date and time of the donation in the pledge.
   * @param newProcessingTime The new processing date and time
   * @throws InvalidTimeException if proposed processing date and time is prior to the creation
   * date and time.
   */
  public void setProcessingTime(LocalDateTime newProcessingTime)
      throws InvalidTimeException {
    this.checkOrderOfProcessTime(newProcessingTime);
    this.processingTime = newProcessingTime;
  }

  /**
   * Removes the processing date and time of the donation in the pledge.
   * @throws NoAvailableTimeException if the processing date and time is not set.
   */
  public void removeProcessingTime() throws NoAvailableTimeException {
    this.checkNonnullProcessTime();
    this.processingTime = null;
  }

  /**
   * Gets the processing date and time of the donation in the pledge.
   * @return The processing date and time of the donation in the pledge.
   * @throws NoAvailableTimeException if the processing date and time is not set.
   */
  public LocalDateTime getProcessingTime() throws NoAvailableTimeException {
    this.checkNonnullProcessTime();
    return this.processingTime;
  }

  /**
   * Checks that the processing date and time have been set.
   * @throws NoAvailableTimeException if the processing date and time is not set.
   */
  private void checkNonnullProcessTime() throws NoAvailableTimeException {
    if (this.isNullProcessingTime()) {
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
    Pledge pledge = (Pledge) o;
    return Objects.equals(this.processingTime, pledge.processingTime);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.processingTime);
  }

  /**
   * Creates a string representation of the Pledge.
   * @return a string representation of the Pledge.
   */
  @Override
  public String toString() {
    return "Pledge{" +
        "amount=" + this.getAmount() +
        ", creationTime=" + this.getCreationTime() +
        ", processingTime=" + this.processingTime +
        '}';
  }
}
