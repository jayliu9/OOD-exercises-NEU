package problem2;

/**
 * An interface specifying required behaviors for a subject
 */
public interface Subject {

  /**
   * Adds an observer to a list of observers
   * @param observer The observer to add
   */
  void registerObserver(LoanObserver observer);

  /**
   * Removes an observer from a list of observers
   * @param observer The observer to remove
   */
  void removeObserver(LoanObserver observer);

  /**
   * Notifies observers if a model was changed
   */
  void notifyObserver();

  /**
   * Changes the interest rate of the loan to a new interest rate.
   * @param newInterest The new interest rate
   */
  void loanInterestChange(double newInterest);
}
