package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleaningTest {
  Cleaning cleaning;

  @Before
  public void setUp() throws Exception {
    cleaning = new Cleaning("Address", PropertySize.LARGE, false, 5, 0);
  }

  @Test
  public void testToString() {
    assertEquals("Cleaning: propertyAddress = Address, size = LARGE,"
        + " isMonthly = false, numOfServices = 5, numOfPets = 0", cleaning.toString());
  }
}