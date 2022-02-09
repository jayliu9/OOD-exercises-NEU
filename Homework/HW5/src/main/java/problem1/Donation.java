package problem1;

/**
 * An interface specifying required behaviors for a donation
 */
public interface Donation {

  /**
   * Gets the amount of the donation processed in the specified year.
   * @param year The year
   * @return The amount of the donation processed in the specified year.
   */
  long getAmountForYear(int year);
}
