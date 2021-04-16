package problem2;

/**
 * Represents an interest media website monitoring the interest rate of a loan.
 */
public class MediaWebObserver implements LoanObserver {
  private String name;

  /**
   * Constructor for the MediaWebObserver class
   * @param name The name of the loan observer
   */
  public MediaWebObserver(String name) {
    this.name = name;
  }

  /**
   * Updates the representation of observable
   * @param observable The observable to update
   */
  @Override
  public void update(Loan observable) {
    System.out.println(this.name + ":" + observable.toString());
  }

  /**
   * Stops updating the information of the specified loan interest rate.
   * @param subject The subject that this observer no longer follows.
   */
  @Override
  public void stopUpdating(Subject subject) {
    subject.removeObserver(this);
  }
}
