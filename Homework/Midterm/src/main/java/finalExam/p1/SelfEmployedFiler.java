package finalExam.p1;

public class SelfEmployedFiler extends IndividualFiler {

  private Double homeOfficeExpense;
  private Double healthInsuranceExpense;
  private Double vehicleUseExpense;
  private Double businessExpense;

  public SelfEmployedFiler(String taxID, ContactInfo contactInfo, Double earningsOfLastYear,
      Double totalIncomeTax, Double mortgageInterest, Double propertyTax,
      Double studentLoanAndTuition, Double retirementSaving, Double healthSaving,
      Double charitableContribution, Double homeOfficeExpense,
      Double healthInsuranceExpense, Double vehicleUseExpense, Double businessExpense) {
    super(taxID, contactInfo, earningsOfLastYear, totalIncomeTax, mortgageInterest, propertyTax,
        studentLoanAndTuition, retirementSaving, healthSaving, charitableContribution);
    this.homeOfficeExpense = homeOfficeExpense;
    this.healthInsuranceExpense = healthInsuranceExpense;
    this.vehicleUseExpense = vehicleUseExpense;
    this.businessExpense = businessExpense;
  }
}
