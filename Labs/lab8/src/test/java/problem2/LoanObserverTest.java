package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LoanObserverTest {
  LoanObserver one;
  LoanObserver another;
  Subject oneSubject;
  Loan loan;

  @Before
  public void setUp() throws Exception {
    loan = new Loan("A", 0.2);
    oneSubject = new LoanUpdate(loan);
    one = new MediaWebObserver("First");
    another = new MediaWebObserver("Second");
    oneSubject.registerObserver(one);
    oneSubject.registerObserver(another);
  }

  @Test
  public void stopUpdating() {
    oneSubject.loanInterestChange(0.25);
    one.stopUpdating(oneSubject);
    oneSubject.loanInterestChange(0.28);
  }
}