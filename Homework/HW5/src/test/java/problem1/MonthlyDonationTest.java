package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class MonthlyDonationTest {
  MonthlyDonation monthly;
  MonthlyDonation nonCancellation;
  MonthlyDonation same;
  String differentType;
  MonthlyDonation nullMonthlyDonation;
  MonthlyDonation differentAmount;
  MonthlyDonation differentCreation;
  MonthlyDonation differentCancellation;


  @Before
  public void setUp() throws Exception {
    LocalDateTime creationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    LocalDateTime cancellationTime = LocalDateTime.of(2019, 11, 10, 9, 59, 59);
    monthly = new MonthlyDonation(10, creationTime);
    monthly.setCancellationTime(cancellationTime);
    nonCancellation = new MonthlyDonation(10, creationTime);
    same = new MonthlyDonation(10, creationTime);
    same.setCancellationTime(cancellationTime);
    differentType = "Monthly donation";
    nullMonthlyDonation = null;
    differentAmount = new MonthlyDonation(15, creationTime);
    differentAmount.setCancellationTime(cancellationTime);
    LocalDateTime anotherCreation = LocalDateTime.of(2019, 5, 15, 10, 0, 0);
    differentCreation = new MonthlyDonation(10, anotherCreation);
    differentCreation.setCancellationTime(cancellationTime);
    differentCancellation = new MonthlyDonation(10, creationTime);
    LocalDateTime anotherCancellation = LocalDateTime.of(2020, 11, 10, 9, 59, 59);
    differentCancellation.setCancellationTime(anotherCancellation);
  }

  @Test
  public void getAmountForYear() {
    assertEquals(90, monthly.getAmountForYear(2019));
    assertEquals(0, monthly.getAmountForYear(2018));
    assertEquals(0, monthly.getAmountForYear(2020));
    assertEquals(110, nonCancellation.getAmountForYear(2019));
    assertEquals(120, nonCancellation.getAmountForYear(2020));
    assertEquals(110, differentCancellation.getAmountForYear(2019));
  }

  @Test
  public void setCancellationTime() throws InvalidTimeException, NoAvailableTimeException {
    LocalDateTime cancellationTime = LocalDateTime.of(2020, 11, 10, 9, 59, 59);
    nonCancellation.setCancellationTime(cancellationTime);
    assertEquals(cancellationTime, nonCancellation.getCancellationTime());
  }

  @Test
  public void getCancellationTime() throws NoAvailableTimeException {
    LocalDateTime testTime = LocalDateTime.of(2019, 11, 10, 9, 59, 59);
    assertEquals(testTime, monthly.getCancellationTime());
  }

  @Test
  public void testEquals() {
    assertTrue(monthly.equals(monthly));
    assertTrue(monthly.equals(same));
    assertFalse(monthly.equals(differentType));
    assertFalse(monthly.equals(nullMonthlyDonation));
    assertFalse(monthly.equals(differentAmount));
    assertFalse(monthly.equals(differentCreation));
    assertFalse(monthly.equals(differentCancellation));
  }

  @Test
  public void testHashCode() {
    assertTrue(monthly.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("MonthlyDonation{amount=10, creationTime=2019-02-10T10:00, cancellationTime=2019-11-10T09:59:59}", monthly.toString());
  }

  @Test(expected = InvalidTimeException.class)
  public void tooEarlyCancellation() throws InvalidTimeException {
    LocalDateTime tooEarly = LocalDateTime.of(2019, 1, 10, 10, 0, 0);
    monthly.setCancellationTime(tooEarly);
  }

  @Test(expected = NoAvailableTimeException.class)
  public void noCancellation() throws NoAvailableTimeException {
    nonCancellation.getCancellationTime();
  }
}