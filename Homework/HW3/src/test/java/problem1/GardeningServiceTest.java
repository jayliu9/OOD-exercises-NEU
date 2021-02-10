package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningServiceTest {
  GardeningService gardening;
  GardeningService notCombineDiscount;

  @Before
  public void setUp() throws Exception {
    gardening = new GardeningService("Address", PropertySize.LARGE, false, 7);
    notCombineDiscount = new GardeningService("Address", PropertySize.LARGE, true, 29);
  }

  @Test
  public void calculatePrice() {
    assertEquals(340.0, gardening.calculatePrice(), 0.000001);
    assertEquals(170.0, notCombineDiscount.calculatePrice(), 0.000001);
  }

  @Test
  public void testToString() {
    assertEquals("GardeningService: propertyAddress = Address, size = LARGE,"
        + " isMonthly = false, numOfServices = 7", gardening.toString());
  }
}