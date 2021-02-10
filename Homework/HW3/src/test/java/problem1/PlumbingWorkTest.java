package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbingWorkTest {
  PlumbingWork plumbingWork;

  @Before
  public void setUp() throws Exception {
    plumbingWork = new PlumbingWork("Address", PropertySize.LARGE, false, 7, 3,false);
  }

  @Test
  public void testToString() {
    assertEquals("PlumbingWork: propertyAddress = Address, size = LARGE,"
            + " isMonthly = false, numOfServices = 7, numOfEmployee = 3, isComplex = false"
        , plumbingWork.toString());
  }

  @Test
  public void calculatePrice() {
    assertEquals(620.0, plumbingWork.calculatePrice(), 0.000001);
  }
}