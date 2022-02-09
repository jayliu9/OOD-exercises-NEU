package finalExam.p2;

import java.time.LocalDate;

/**
 * An ADT called LoanProcessingSystem used to store and process the received loan applications.
 */
public interface ILoanProcessingSystem {

  /**
   * Checks whether or not the LoanProcessingSystem is empty
   * @return true if the LoanProcessingSystem is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * Gets the number of courses in the course catalog.
   * @return The number of courses in the course catalog.
   */
  Integer count();

  /**
   * Adds a LoanApplication to the LoanProcessingSystem.
   * @param loanApplication The LoanApplication to add
   */
  void add(LoanApplication loanApplication);

  /**
   * Removes a LoanApplication from the LoanProcessingSystem.
   * @param loanApplication The LoanApplication to remove
   */
  void remove(LoanApplication loanApplication) throws LoanApplicationNotFoundException;

  /**
   * Finds and returns all LoanApplications from the LoanProcessingSystem that were submitted on the
   * same day.
   * @param dateLoanSubmitted The given day
   * @return An array of all LoanApplications from the LoanProcessingSystem that were submitted on the
   * same day.
   */
  ILoanProcessingSystem findOnSameDay(LocalDate dateLoanSubmitted);

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is greater than $50000 per year.
   * @return An array of all LoanApplications from the LoanProcessingSystem where the requested amount
   * is greater than $50000 per year.
   */
  ILoanProcessingSystem findOnAmount();

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the annual interest rate
   * is greater than 3 percent.
   * @return An array of all LoanApplications from the LoanProcessingSystem where the annual interest rate
   * is greater than 3 percent.
   */
  ILoanProcessingSystem findOnAPR();

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the expected loan
   * repayment period is greater than 10 years.
   * @return An array of all LoanApplications from the LoanProcessingSystem where the expected loan
   * repayment period is greater than 10 years.
   */
  ILoanProcessingSystem findOnPeriod();

  /**
   * Gets a LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s unique
   * identifier, loanID.
   * @param loanID The given loanID
   * @return The LoanApplication with the given loanID
   */
  LoanApplication getApplicationOnID(String loanID);

}
