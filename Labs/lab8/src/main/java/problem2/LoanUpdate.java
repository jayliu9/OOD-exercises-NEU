package problem2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an update that maintains state of loan.
 */
public class LoanUpdate implements Subject {

  private Loan loan;
  private List<LoanObserver> observers;

  /**
   * Constructor for the LoanUpdate
   * @param loan The loan of the subject
   */
  public LoanUpdate(Loan loan) {
    this.loan = loan;
    this.observers = new ArrayList<>();
  }

  /**
   * Adds an observer to a list of observers
   * @param observer The observer to add
   */
  @Override
  public void registerObserver(LoanObserver observer) {
    this.observers.add(observer);

  }

  /**
   * Removes an observer from a list of observers
   * @param observer The observer to remove
   */
  @Override
  public void removeObserver(LoanObserver observer) {
    this.observers.remove(observer);
  }

  /**
   * Notifies observers if a model was changed
   */
  @Override
  public void notifyObserver() {
    for (LoanObserver observer : this.observers) {
      observer.update(this.loan);
    }
  }

  /**
   * Changes the interest rate of the loan to a new interest rate.
   * @param newInterest The new interest rate
   */
  @Override
  public void loanInterestChange(double newInterest) {
    this.loan.setInterest(newInterest);
    this.notifyObserver();
  }

}
