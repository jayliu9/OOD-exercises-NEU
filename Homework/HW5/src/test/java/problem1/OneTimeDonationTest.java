package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class OneTimeDonationTest {
  OneTimeDonation oneTime;

  @Before
  public void setUp() throws Exception {
    LocalDateTime creationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    oneTime = new OneTimeDonation(100, creationTime);
  }

  @Test
  public void getAmountForYear() {
    assertEquals(100, oneTime.getAmountForYear(2019));
    assertEquals(0, oneTime.getAmountForYear(2020));
    assertEquals(0, oneTime.getAmountForYear(2015));
  }

  @Test
  public void testToString() {
    assertEquals("OneTimeDonation{amount=100, creationTime=2019-02-10T10:00}"
        , oneTime.toString());
  }

  @Test
  public void getAmount() {
    assertEquals(100, oneTime.getAmount());
  }

  @Test
  public void getCreationTime() {
    LocalDateTime testCreationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    assertEquals(testCreationTime, oneTime.getCreationTime());
  }
}