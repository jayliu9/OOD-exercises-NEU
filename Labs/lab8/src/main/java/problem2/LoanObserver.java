package problem2;

/**
 * An interface specifying required behaviors for a loan observer
 */
public interface LoanObserver {

  /**
   * Updates the representation of observable
   * @param observable The observable to update
   */
  void update(Loan observable);

  /**
   * Stops updating the information of the specified loan interest rate.
   * @param subject The subject that this observer no longer follows.
   */
  void stopUpdating(Subject subject);

}
