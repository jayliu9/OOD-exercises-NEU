package finalExam.p1;

public abstract class AbstractTaxFiler implements TaxFiler {

  private String taxID;
  private ContactInfo contactInfo;
  protected Double earningsOfLastYear;
  private Double totalIncomeTax;
  private Double mortgageInterest;
  private Double propertyTax;
  protected Double studentLoanAndTuition;
  private Double retirementSaving;
  private Double healthSaving;
  protected Double charitableContribution;
  private static final Integer EARNING_FOR_MORTGAGE_PROPERTY_DEDUCTION = 150000;
  private static final Integer EXPENSES_FOR_MORTGAGE_PROPERTY_DEDUCTION = 12500;
  private static final Integer MORTGAGE_PROPERTY_DEDUCTION = 2500;

  protected AbstractTaxFiler(String taxID, ContactInfo contactInfo, Double earningsOfLastYear,
      Double totalIncomeTax, Double mortgageInterest, Double propertyTax,
      Double studentLoanAndTuition, Double retirementSaving, Double healthSaving,
      Double charitableContribution) {
    this.taxID = taxID;
    this.contactInfo = contactInfo;
    this.earningsOfLastYear = earningsOfLastYear;
    this.totalIncomeTax = totalIncomeTax;
    this.mortgageInterest = mortgageInterest;
    this.propertyTax = propertyTax;
    this.studentLoanAndTuition = studentLoanAndTuition;
    this.retirementSaving = retirementSaving;
    this.healthSaving = healthSaving;
    this.charitableContribution = charitableContribution;
  }

  protected Boolean shouldGetDeduction(Integer earningThreshold, Double expense,
      Integer expenseThreshold) {
    return this.earningsOfLastYear < earningThreshold && expense > expenseThreshold;
  }

  protected Double getBasicTaxableIncome() {
    return this.earningsOfLastYear - this.totalIncomeTax;
  }

  private Boolean shouldGetMortgagePropertyDeduction() {
    return this.shouldGetDeduction(EARNING_FOR_MORTGAGE_PROPERTY_DEDUCTION,
        this.mortgageInterest + this.propertyTax,
        EXPENSES_FOR_MORTGAGE_PROPERTY_DEDUCTION);
  }

  protected Integer getMortgageAndPropertyDeduction() {
    return this.shouldGetMortgagePropertyDeduction() ? MORTGAGE_PROPERTY_DEDUCTION : 0;
  }

  protected Double getSumOfSavings() {
    return this.healthSaving + this.retirementSaving;
  }
}
