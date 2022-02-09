package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  NonProfit hasNoDonation;
  NonProfit nonProfit;
  Donation firstDonation;
  Donation secondDonation;
  Donation thirdDonation;
  NonProfit same;
  NonProfit nullNonProfit;
  String differentType;
  NonProfit differentName;


  @Before
  public void setUp() throws Exception {
    hasNoDonation = new NonProfit("Non-profit");
    nonProfit = new NonProfit("Non-profit");
    LocalDateTime firstCreationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    firstDonation = new OneTimeDonation(100, firstCreationTime);
    LocalDateTime secondCreationTime = LocalDateTime.of(2020, 5, 10, 10, 7, 22);
    secondDonation = new MonthlyDonation(10, secondCreationTime);
    LocalDateTime thirdCreationTime = LocalDateTime.of(2018, 7, 18, 10, 0, 30);
    LocalDateTime processingTime = LocalDateTime.of(2019, 7, 18, 10, 0, 30);
    thirdDonation = new Pledge(150, thirdCreationTime, processingTime);
    nonProfit.receive(firstDonation);
    nonProfit.receive(secondDonation);
    nonProfit.receive(thirdDonation);
    same = new NonProfit("Non-profit");
    same.receive(firstDonation);
    same.receive(secondDonation);
    same.receive(thirdDonation);
    nullNonProfit = null;
    differentType = "Non-profit";
    differentName = new NonProfit("Different Name");
    differentName.receive(firstDonation);
    differentName.receive(secondDonation);
    differentName.receive(thirdDonation);
  }

  @Test
  public void receive() throws InvalidTimeException {
    LocalDateTime testFirstCreationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    Donation testFirstDonation = new OneTimeDonation(100, testFirstCreationTime);
    LocalDateTime testSecondCreationTime = LocalDateTime.of(2020, 5, 10, 10, 7, 22);
    Donation testSecondDonation = new MonthlyDonation(10, testSecondCreationTime);
    LocalDateTime testThirdCreationTime = LocalDateTime.of(2018, 7, 18, 10, 0, 30);
    LocalDateTime testProcessingTime = LocalDateTime.of(2019, 7, 18, 10, 0, 30);
    Donation testThirdDonation = new Pledge(150, testThirdCreationTime, testProcessingTime);
    hasNoDonation.receive(testFirstDonation);
    hasNoDonation.receive(testSecondDonation);
    hasNoDonation.receive(testThirdDonation);
    assertEquals(nonProfit, hasNoDonation);
  }

  @Test
  public void remove() throws InvalidRemovalException, InvalidTimeException {
    LocalDateTime testFirstCreationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    Donation testFirstDonation = new OneTimeDonation(100, testFirstCreationTime);
    LocalDateTime testSecondCreationTime = LocalDateTime.of(2020, 5, 10, 10, 7, 22);
    Donation testSecondDonation = new MonthlyDonation(10, testSecondCreationTime);
    LocalDateTime testThirdCreationTime = LocalDateTime.of(2018, 7, 18, 10, 0, 30);
    LocalDateTime testProcessingTime = LocalDateTime.of(2019, 7, 18, 10, 0, 30);
    Donation testThirdDonation = new Pledge(150, testThirdCreationTime, testProcessingTime);
    nonProfit.remove(testFirstDonation);
    nonProfit.remove(testSecondDonation);
    nonProfit.remove(testThirdDonation);
    assertEquals(hasNoDonation, nonProfit);
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(250, nonProfit.getTotalDonationsForYear(2019));
    assertEquals(0, hasNoDonation.getTotalDonationsForYear(2020));
    assertEquals(80, nonProfit.getTotalDonationsForYear(2020));
  }

  @Test
  public void getName() {
    assertEquals("Non-profit", nonProfit.getName());
  }

  @Test
  public void getDonations() throws InvalidTimeException {
    Set<Donation> test = new HashSet<>();
    LocalDateTime testFirstCreationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    Donation testFirstDonation = new OneTimeDonation(100, testFirstCreationTime);
    LocalDateTime testSecondCreationTime = LocalDateTime.of(2020, 5, 10, 10, 7, 22);
    Donation testSecondDonation = new MonthlyDonation(10, testSecondCreationTime);
    LocalDateTime testThirdCreationTime = LocalDateTime.of(2018, 7, 18, 10, 0, 30);
    LocalDateTime testProcessingTime = LocalDateTime.of(2019, 7, 18, 10, 0, 30);
    Donation testThirdDonation = new Pledge(150, testThirdCreationTime, testProcessingTime);
    test.add(testSecondDonation);
    test.add(testThirdDonation);
    test.add(testFirstDonation);
    assertEquals(test, nonProfit.getDonations());
  }

  @Test
  public void testEquals() {
    assertTrue(nonProfit.equals(nonProfit));
    assertTrue(nonProfit.equals(same));
    assertFalse(nonProfit.equals(differentType));
    assertFalse(nonProfit.equals(nullNonProfit));
    assertFalse(nonProfit.equals(hasNoDonation));
    assertFalse(nonProfit.equals(differentName));
  }

  @Test
  public void testHashCode() {
    assertTrue(nonProfit.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("NonProfit{name='Non-profit', donations=[]}", hasNoDonation.toString());
  }

  @Test(expected = InvalidRemovalException.class)
  public void invalidRemoval() throws InvalidRemovalException {
    hasNoDonation.remove(firstDonation);
  }
}