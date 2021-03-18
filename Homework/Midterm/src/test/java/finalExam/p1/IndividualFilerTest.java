package finalExam.p1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndividualFilerTest {

  IndividualFiler lowerLoanAndTuition;
  IndividualFiler higherLoanAndTuition;
  IndividualFiler higherEarning;
  IndividualFiler selfEmployedFiler;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Harry", "Potter");
    String taxID =  "123456";
    ContactInfo contactInfo = new ContactInfo(name, "A street", "6666666", "harry@test.com");
    lowerLoanAndTuition = new Employee(taxID, contactInfo, 70000.0,
        15000.0, 10000.0, 5000.0,
        3500.0, 500.0, 500.0, 3200.0);
    higherLoanAndTuition = new Employee(taxID, contactInfo, 70000.0,
        15000.0, 10000.0, 5000.0,
        6500.0, 500.0, 500.0, 3200.0);
    higherEarning = new Employee(taxID, contactInfo, 90000.0,
        15000.0, 10000.0, 5000.0,
        6500.0, 500.0, 500.0, 3200.0);
    selfEmployedFiler = new SelfEmployedFiler(taxID, contactInfo, 90000.0,
        15000.0, 10000.0, 5000.0,
        6500.0, 500.0, 500.0, 3200.0,
        2500.0, 2000.0, 3000.0, 3500.0);
  }

  @Test
  public void calculateTax() {
    assertEquals(Double.valueOf(7065.0), higherLoanAndTuition.calculateTax());
    assertEquals(Double.valueOf(7290.0), lowerLoanAndTuition.calculateTax());
    assertEquals(Double.valueOf(13034.0), higherEarning.calculateTax());
  }
}