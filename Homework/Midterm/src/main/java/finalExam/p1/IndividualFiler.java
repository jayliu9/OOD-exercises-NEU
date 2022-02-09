package finalExam.p1;

public abstract class IndividualFiler extends AbstractTaxFiler {

  private static final Double COEFFICIENT_OF_SAVING = 0.7;
  private static final Integer EARNING_FOR_STUDENT_LOAN_DEDUCTION = 75000;
  private static final Integer EXPENSES_FOR_STUDENT_LOAN_DEDUCTION = 5000;
  private static final Integer STUDENT_LOAN_DEDUCTION = 1500;
  private static final Double LOWER_TAX_COEFFICIENT = 0.15;
  private static final Double HIGHER_TAX_COEFFICIENT = 0.19;
  private static final Integer HIGHER_INCOME_THRESHOLD = 55000;

  protected IndividualFiler(String taxID, ContactInfo contactInfo, Double earningsOfLastYear,
      Double totalIncomeTax, Double mortgageInterest, Double propertyTax,
      Double studentLoanAndTuition, Double retirementSaving, Double healthSaving,
      Double charitableContribution) {
    super(taxID, contactInfo, earningsOfLastYear, totalIncomeTax, mortgageInterest, propertyTax,
        studentLoanAndTuition, retirementSaving, healthSaving, charitableContribution);
  }

  private Boolean shouldGetStudentLoanDeduction() {
    return this.shouldGetDeduction(EARNING_FOR_STUDENT_LOAN_DEDUCTION, this.studentLoanAndTuition,
        EXPENSES_FOR_STUDENT_LOAN_DEDUCTION);
  }

  protected Integer getStudentLoanDeduction() {
    return this.shouldGetStudentLoanDeduction() ? STUDENT_LOAN_DEDUCTION : 0;
  }

  protected Double getSavingDeduction() {
    return this.getSumOfSavings() * COEFFICIENT_OF_SAVING;
  }

  private Double getResultingTaxableIncome() {
    return this.getBasicTaxableIncome() - this.charitableContribution - this.getSavingDeduction() -
        this.getStudentLoanDeduction() - this.getMortgageAndPropertyDeduction();
  }

  private Boolean isHigherIncome(Double resultingTaxableIncome) {
    return resultingTaxableIncome > HIGHER_INCOME_THRESHOLD;
  }

  @Override
  public Double calculateTax() {
    Double resultingTaxableIncome = this.getResultingTaxableIncome();
    if (isHigherIncome(resultingTaxableIncome)) {
      return resultingTaxableIncome * HIGHER_TAX_COEFFICIENT;
    }
    return resultingTaxableIncome * LOWER_TAX_COEFFICIENT;
  }
}
