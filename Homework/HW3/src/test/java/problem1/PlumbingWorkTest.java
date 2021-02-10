package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbingWorkTest {
  PlumbingWork plumbingWork;
  PlumbingWork manyEmployees;
  PlumbingWork isComplexWork;

  @Before
  public void setUp() throws Exception {
    plumbingWork = new PlumbingWork("Address", PropertySize.LARGE, false, 7, 3,false);
    manyEmployees = new PlumbingWork("Address", PropertySize.LARGE, false, 7, 10,false);
    isComplexWork = new PlumbingWork("Address", PropertySize.LARGE, false, 7, 10,true);
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
    assertEquals(2020.0, manyEmployees.calculatePrice(), 0.000001);
    assertEquals(2020.0, isComplexWork.calculatePrice(), 0.000001);
  }
}