package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoanTest {

  Loan loan;

  @Before
  public void setUp() throws Exception {
    loan = new Loan("A", 0.2);
  }

  @Test
  public void getInterest() {
    assertEquals(0.2, loan.getInterest(), 0.00001);
  }

  @Test
  public void setInterest() {
    loan.setInterest(0.3);
    assertEquals(0.3, loan.getInterest(), 0.00001);
  }

  @Test
  public void testToString() {
    assertEquals("Loan{type='A', interest=0.2}", loan.toString());
  }
}