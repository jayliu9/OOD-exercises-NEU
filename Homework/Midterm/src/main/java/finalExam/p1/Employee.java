package finalExam.p1;

public class Employee extends IndividualFiler {

  public Employee(String taxID, ContactInfo contactInfo, Double earningsOfLastYear,
      Double totalIncomeTax, Double mortgageInterest, Double propertyTax,
      Double studentLoanAndTuition, Double retirementSaving, Double healthSaving,
      Double charitableContribution) {
    super(taxID, contactInfo, earningsOfLastYear, totalIncomeTax, mortgageInterest, propertyTax,
        studentLoanAndTuition, retirementSaving, healthSaving, charitableContribution);
  }
}
