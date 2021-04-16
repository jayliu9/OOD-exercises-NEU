package problem2;

/**
 * Represents a loan with specific type and interest rate
 */
public class Loan {
  private String type;
  private double interest;

  /**
   * Constructor for the Loan class
   * @param type The type of the loan
   * @param interest The interest rate of the loan
   */
  public Loan(String type, double interest) {
    this.type = type;
    this.interest = interest;
  }

  /**
   * Gets the interest rate of the loan
   * @return The interest of the loan
   */
  public double getInterest() {
    return this.interest;
  }

  /**
   * Sets a new interest rate of the loan
   * @param interest The new interest rate
   */
  public void setInterest(double interest) {
    this.interest = interest;
  }

  /**
   * Creates a string representation of the Loan.
   * @return a string representation of the Loan.
   */
  @Override
  public String toString() {
    return "Loan{" +
        "type='" + type + '\'' +
        ", interest=" + interest +
        '}';
  }
}
