package finalExam.p1;

public class SmallBusinessTaxFiler extends AbstractTaxFiler {

  private Integer numOfEmployees;
  private Double employeeExpense;
  private Double businessExpense;
  private static final Integer CREDIT_PER_EMPLOYEE = 2500;
  private static final Double TAX_COEFFICIENT = 0.15;

  public SmallBusinessTaxFiler(String taxID, ContactInfo contactInfo,
      Double earningsOfLastYear, Double totalIncomeTax, Double mortgageInterest,
      Double propertyTax, Double studentLoanAndTuition, Double retirementSaving,
      Double healthSaving, Double charitableContribution, Integer numOfEmployees,
      Double employeeExpense, Double businessExpense) {
    super(taxID, contactInfo, earningsOfLastYear, totalIncomeTax, mortgageInterest, propertyTax,
        studentLoanAndTuition, retirementSaving, healthSaving, charitableContribution);
    this.numOfEmployees = numOfEmployees;
    this.employeeExpense = employeeExpense;
    this.businessExpense = businessExpense;
  }

  private Integer getCredit() {
    return this.numOfEmployees * CREDIT_PER_EMPLOYEE;
  }

  private Double getResultingTaxableIncome() {
    return this.getBasicTaxableIncome() - this.charitableContribution - this.businessExpense
        - this.employeeExpense - this.getCredit();
  }

  @Override
  public Double calculateTax() {
    return this.getResultingTaxableIncome() * TAX_COEFFICIENT;
  }
}
