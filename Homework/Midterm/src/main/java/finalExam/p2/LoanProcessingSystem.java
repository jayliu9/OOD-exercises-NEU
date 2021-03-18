package finalExam.p2;

import java.time.LocalDate;

public class LoanProcessingSystem implements ILoanProcessingSystem {

  private LoanApplication[] applications;
  private Integer numOfApplications;
  private static final int DEFAULT_NUM_OF_SLOTS = 5;
  private static final int NOT_EXIST = -1;
  private static final int REQUEST_AMOUNT_THRESHOLD = 50000;
  private static final double EXPECTED_APR = 0.03;
  private static final int EXPECTED_PERIOD = 10;

  public LoanProcessingSystem() {
    this.applications = new LoanApplication[DEFAULT_NUM_OF_SLOTS];
    this.numOfApplications = 0;
  }

  /**
   * Checks whether or not the LoanProcessingSystem is empty
   *
   * @return true if the LoanProcessingSystem is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.numOfApplications == 0;
  }

  /**
   * Gets the number of courses in the course catalog.
   *
   * @return The number of courses in the course catalog.
   */
  @Override
  public Integer count() {
    return this.numOfApplications;
  }

  /**
   * Adds a LoanApplication to the LoanProcessingSystem.
   *
   * @param loanApplication The LoanApplication to add
   */
  @Override
  public void add(LoanApplication loanApplication) {
    if (this.overLength()) {
      this.resize();
    }
    this.applications[this.numOfApplications] = loanApplication;
    this.numOfApplications++;
  }

  /**
   * Increases the size of the data array.
   */
  private void resize() {
    int newSize = this.applications.length + DEFAULT_NUM_OF_SLOTS;
    LoanApplication[] newList = new LoanApplication[newSize];
    this.copyArray(this.applications, newList);
    this.applications = newList;
  }

  /**
   * Helper function that copies the whole of the "from" array to the "to" array.
   * @param from The array to copy from
   * @param to The array to copy to
   */
  private void copyArray(LoanApplication[] from, LoanApplication[] to) {
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
    }
  }

  private boolean overLength() {
    return this.numOfApplications + 1 > this.applications.length;
  }

  /**
   * Removes a LoanApplication from the LoanProcessingSystem.
   *
   * @param loanApplication The LoanApplication to remove
   */
  @Override
  public void remove(LoanApplication loanApplication) throws LoanApplicationNotFoundException {
    int indexToRemove = this.indexOf(loanApplication);
    boolean isFound = indexToRemove != NOT_EXIST;
    if (!isFound) {
      throw new LoanApplicationNotFoundException();
    } else {
      this.shiftDown(this.applications, indexToRemove + 1);
      this.numOfApplications--;
    }
  }

  public int indexOf(LoanApplication loanApplication) {
    for (int i = 0; i < this.numOfApplications; i++) {
      if (applications.equals(this.applications[i])) {
        return i;
      }
    }
    return NOT_EXIST;
  }

  /**
   * Checks if the specified loanApplication exists in the system
   * @param loanApplication The loanApplication to check
   * @return true if the loanApplication exist in the system, false otherwise.
   */
  private boolean contains(LoanApplication loanApplication) {
    if (this.indexOf(loanApplication) == NOT_EXIST) {
      return false;
    }
    return true;
  }

  /**
   * Helper function that moves down all the items after a given index (inclusive) by 1.
   * @param array The array in which the items are going to be moved
   * @param startIndex The starting index to move the items from
   */
  private void shiftDown(LoanApplication[] array, int startIndex) {
    for (int i = startIndex; i < this.numOfApplications; i++) {
      array[i - 1] = array[i];
    }
  }

  /**
   * Finds and returns all LoanApplications from the LoanProcessingSystem that were submitted on the
   * same day.
   *
   * @param dateLoanSubmitted The given day
   * @return An array of all LoanApplications from the LoanProcessingSystem that were submitted on
   * the same day.
   */
  @Override
  public ILoanProcessingSystem findOnSameDay(LocalDate dateLoanSubmitted) {
    ILoanProcessingSystem newList = new LoanProcessingSystem();
    for(int i = 0; i < this.numOfApplications; i++) {
      if(applications[i].getDateLoanSubmitted().equals(dateLoanSubmitted)) {
        newList.add(applications[i]);
      }
    }
    return newList;
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the requested amount
   * is greater than $50000 per year.
   *
   * @return An array of all LoanApplications from the LoanProcessingSystem where the requested
   * amount is greater than $50000 per year.
   */
  @Override
  public ILoanProcessingSystem findOnAmount() {
    ILoanProcessingSystem newList = new LoanProcessingSystem();
    for(int i = 0; i < this.numOfApplications; i++) {
      if(applications[i].getRequestedAmount() > REQUEST_AMOUNT_THRESHOLD)) {
        newList.add(applications[i]);
      }
    }
    return newList;
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the annual interest
   * rate is greater than 3 percent.
   *
   * @return An array of all LoanApplications from the LoanProcessingSystem where the annual
   * interest rate is greater than 3 percent.
   */
  @Override
  public ILoanProcessingSystem findOnAPR() {
    ILoanProcessingSystem newList = new LoanProcessingSystem();
    for(int i = 0; i < this.numOfApplications; i++) {
      if(applications[i].getAnnualAPR() > EXPECTED_APR)) {
        newList.add(applications[i]);
      }
    }
    return newList;
  }

  /**
   * Find and return all LoanApplications from the LoanProcessingSystem where the expected loan
   * repayment period is greater than 10 years.
   *
   * @return An array of all LoanApplications from the LoanProcessingSystem where the expected loan
   * repayment period is greater than 10 years.
   */
  @Override
  public ILoanProcessingSystem findOnPeriod() {
    ILoanProcessingSystem newList = new LoanProcessingSystem();
    for(int i = 0; i < this.numOfApplications; i++) {
      if(applications[i].getLoanDurationInYears() > EXPECTED_PERIOD)) {
        newList.add(applications[i]);
      }
    }
    return newList;
  }

  /**
   * Gets a LoanApplication from the LoanProcessingSystem based upon the LoanApplications’s unique
   * identifier, loanID.
   *
   * @param loanID The given loanID
   * @return The LoanApplication with the given loanID
   */
  @Override
  public LoanApplication getApplicationOnID(String loanID) {
    return null;
  }
}
