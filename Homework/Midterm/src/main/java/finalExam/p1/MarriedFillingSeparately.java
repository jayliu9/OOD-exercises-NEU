package finalExam.p1;

public class MarriedFillingSeparately extends GroupFiler {

  public MarriedFillingSeparately(String taxID, ContactInfo contactInfo,
      Double earningsOfLastYear, Double totalIncomeTax, Double mortgageInterest,
      Double propertyTax, Double studentLoanAndTuition, Double retirementSaving,
      Double healthSaving, Double charitableContribution, Integer numOfDependants,
      Integer numOfMinors, Double childcareExpense, Double dependantCareExpense) {
    super(taxID, contactInfo, earningsOfLastYear, totalIncomeTax, mortgageInterest, propertyTax,
        studentLoanAndTuition, retirementSaving, healthSaving, charitableContribution,
        numOfDependants, numOfMinors, childcareExpense, dependantCareExpense);
  }
}
