package finalExam.p1;

public abstract class GroupFiler extends AbstractTaxFiler {

  private Integer numOfDependants;
  private Integer numOfMinors;
  private Double childcareExpense;
  private Double dependantCareExpense;
  private static final Double COEFFICIENT_OF_SAVING = 0.65;
  private static final Integer EARNING_FOR_STUDENT_LOAN_DEDUCTION = 200000;
  private static final Integer EXPENSES_FOR_STUDENT_LOAN_DEDUCTION = 7500;
  private static final Integer STUDENT_LOAN_DEDUCTION = 2500;
  private static final Integer MAX_SAVING_DEDUCTION = 17500;
  private static final Integer EARNING_FOR_CHILDCARE_DEDUCTION = 200000;
  private static final Integer EXPENSE_FOR_CHILDCARE_DEDUCTION = 5000;
  private static final Integer CHILDCARE_DEDUCTION = 1250;
  private static final Integer EARNING_FOR_CARE_CREDIT = 75000;
  private static final Integer CREDIT_PER_MINOR_CHILD = 750;
  private static final Double LOWER_TAX_COEFFICIENT = 0.145;
  private static final Double HIGHER_TAX_COEFFICIENT = 0.19;
  private static final Integer HIGHER_INCOME_THRESHOLD = 90000;

  protected GroupFiler(String taxID, ContactInfo contactInfo, Double earningsOfLastYear,
      Double totalIncomeTax, Double mortgageInterest, Double propertyTax,
      Double studentLoanAndTuition, Double retirementSaving, Double healthSaving,
      Double charitableContribution, Integer numOfDependants, Integer numOfMinors,
      Double childcareExpense, Double dependantCareExpense) {
    super(taxID, contactInfo, earningsOfLastYear, totalIncomeTax, mortgageInterest, propertyTax,
        studentLoanAndTuition, retirementSaving, healthSaving, charitableContribution);
    this.numOfDependants = numOfDependants;
    this.numOfMinors = numOfMinors;
    this.childcareExpense = childcareExpense;
    this.dependantCareExpense = dependantCareExpense;
  }

  private Boolean shouldGetStudentLoanDeduction() {
    return this.shouldGetDeduction(EARNING_FOR_STUDENT_LOAN_DEDUCTION, this.studentLoanAndTuition,
        EXPENSES_FOR_STUDENT_LOAN_DEDUCTION);
  }

  protected Integer getStudentLoanDeduction() {
    return this.shouldGetStudentLoanDeduction() ? STUDENT_LOAN_DEDUCTION : 0;
  }

  private Double validateSavingDeduction(Double sumOfSavings) {
    return sumOfSavings > MAX_SAVING_DEDUCTION ? MAX_SAVING_DEDUCTION : sumOfSavings;
  }

  protected Double getSavingDeduction() {
    return this.validateSavingDeduction(this.getSumOfSavings()) * COEFFICIENT_OF_SAVING;
  }

  private Boolean shouldGetChildcareDeduction() {
    return this.shouldGetDeduction(EARNING_FOR_CHILDCARE_DEDUCTION, this.childcareExpense,
        EXPENSE_FOR_CHILDCARE_DEDUCTION);
  }

  protected Integer getChildcareDeduction() {
    return this.shouldGetChildcareDeduction() ? CHILDCARE_DEDUCTION : 0;
  }

  private Boolean shouldGetCareCredit() {
    return this.earningsOfLastYear > EARNING_FOR_CARE_CREDIT;
  }

  protected Integer getCareCredit() {
    return this.shouldGetCareCredit() ? this.numOfMinors * CREDIT_PER_MINOR_CHILD : 0;
  }

  private Double getResultingTaxableIncome() {
    return this.getBasicTaxableIncome() - this.charitableContribution - this.getSavingDeduction() -
        this.getStudentLoanDeduction() - this.getMortgageAndPropertyDeduction() -
        this.getChildcareDeduction();
  }

  private Boolean isHigherIncome(Double resultingTaxableIncome) {
    return resultingTaxableIncome > HIGHER_INCOME_THRESHOLD;
  }

  @Override
  public Double calculateTax() {
    Double resultingTaxableIncome = this.getResultingTaxableIncome();
    if(isHigherIncome(resultingTaxableIncome)) {
      return resultingTaxableIncome * HIGHER_TAX_COEFFICIENT - this.getCareCredit();
    }
    return resultingTaxableIncome * LOWER_TAX_COEFFICIENT - this.getCareCredit();
  }
}
