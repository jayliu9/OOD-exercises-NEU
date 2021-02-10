package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WindowCleaningTest {
  WindowCleaning smallProperty;
  WindowCleaning mediumProperty;
  WindowCleaning moreThanOneFloor;
  WindowCleaning equalProperty;

  @Before
  public void setUp() throws Exception {
    smallProperty = new WindowCleaning("Address", PropertySize.SMALL, false, 7, 1);
    mediumProperty = new WindowCleaning("Address", PropertySize.MEDIUM, false, 7, 1);
    moreThanOneFloor = new WindowCleaning("Address", PropertySize.SMALL, false, 7, 3);
    equalProperty = new WindowCleaning("Address", PropertySize.SMALL, false, 7, 1);
  }

  @Test
  public void calculatePrice() {
    assertEquals(80.0, smallProperty.calculatePrice(), 0.000001);
    assertEquals(160.0, mediumProperty.calculatePrice(), 0.000001);
    assertEquals(84.0, moreThanOneFloor.calculatePrice(), 0.000001);
  }
  @Test
  public void testEquals() {
    assertFalse(smallProperty.equals(moreThanOneFloor));
    assertFalse(smallProperty.equals(mediumProperty));
    assertTrue(smallProperty.equals(equalProperty));
  }

  @Test
  public void testHashCode() {
    assertTrue(smallProperty.hashCode() == equalProperty.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("WindowCleaning: propertyAddress = Address, size = SMALL,"
        + " isMonthly = false, numOfServices = 7, numOfFloor = 1", smallProperty.toString());
  }

  @Test(expected = InvalidFloorException.class)
  public void invalidNumOfFloor() throws InvalidFloorException {
    WindowCleaning invalidNumOfFloor = new WindowCleaning("Address", PropertySize.SMALL, false, 7, 5);

  }
}