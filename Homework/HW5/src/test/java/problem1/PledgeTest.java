package problem1;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

public class PledgeTest {
  Pledge hasProcessTime;
  Pledge hasNoProcessTime;
  Pledge same;
  Pledge differentProcessTime;
  String differentType;

  @Before
  public void setUp() throws Exception {
    LocalDateTime creationTime = LocalDateTime.of(2019, 2, 10, 10, 0, 0);
    LocalDateTime processingTime = LocalDateTime.of(2021, 10, 20, 10, 0, 0);
    hasProcessTime = new Pledge(150, creationTime, processingTime);
    hasNoProcessTime = new Pledge(150, creationTime);
    same = new Pledge(150, creationTime, processingTime);
    differentProcessTime = new Pledge(150, creationTime, processingTime);
    LocalDateTime anotherProcessingTime = LocalDateTime.of(2021, 11, 25, 10, 0, 0);
    differentProcessTime.setProcessingTime(anotherProcessingTime);
    differentType = "Pledge";
  }

  @Test
  public void getAmountForYear() {
    assertEquals(150, hasProcessTime.getAmountForYear(2021));
    assertEquals(0, hasProcessTime.getAmountForYear(2020));
    assertEquals(0, hasProcessTime.getAmountForYear(2022));
    assertEquals(0, hasProcessTime.getAmountForYear(2017));
    assertEquals(0, hasNoProcessTime.getAmountForYear(2021));
  }

  @Test
  public void setProcessingTime() throws InvalidTimeException, NoAvailableTimeException {
    LocalDateTime newProcessingTime = LocalDateTime.of(2022, 5, 20, 10, 0, 0);
    hasNoProcessTime.setProcessingTime(newProcessingTime);
    assertEquals(newProcessingTime, hasNoProcessTime.getProcessingTime());
  }

  @Test
  public void removeProcessingTime() throws NoAvailableTimeException {
    hasProcessTime.removeProcessingTime();
    assertEquals(hasNoProcessTime, hasProcessTime);
  }

  @Test
  public void getProcessingTime() throws NoAvailableTimeException {
    LocalDateTime testProcessingTime = LocalDateTime.of(2021, 10, 20, 10, 0, 0);
    assertEquals(testProcessingTime, hasProcessTime.getProcessingTime());
  }

  @Test
  public void testEquals() {
    assertFalse(hasProcessTime.equals(differentType));
    assertTrue(hasProcessTime.equals(same));
    assertFalse(hasProcessTime.equals(differentProcessTime));
  }

  @Test
  public void testHashCode() {
    assertTrue(hasProcessTime.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Pledge{amount=150, creationTime=2019-02-10T10:00"
        + ", processingTime=2021-10-20T10:00}", hasProcessTime.toString());
  }

  @Test(expected = InvalidTimeException.class)
  public void tooEarlyProcess() throws InvalidTimeException {
    LocalDateTime tooEarly = LocalDateTime.of(2018, 2, 10, 10, 0, 0);
    hasNoProcessTime.setProcessingTime(tooEarly);
  }

  @Test(expected = NoAvailableTimeException.class)
  public void noProcessingTime() throws NoAvailableTimeException {
    hasNoProcessTime.getProcessingTime();
  }
}