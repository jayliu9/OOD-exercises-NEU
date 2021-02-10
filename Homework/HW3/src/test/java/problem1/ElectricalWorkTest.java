package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricalWorkTest {
  ElectricalWork electricalWork;
  ElectricalWork equalWork;
  ElectricalWork differentNumOfEmployee;
  ElectricalWork differentSize;
  ElectricalWork isNotComplex;
  ElectricalWork tooFewEmployee;
  ElectricalWork complexWorkForLarge;
  ElectricalWork complexWorkForSmall;


  @Before
  public void setUp() throws Exception {
    electricalWork = new ElectricalWork("Address", PropertySize.LARGE, false, 7, 3,false);
    equalWork =  new ElectricalWork("Address", PropertySize.LARGE, false, 7, 3,false);
    differentNumOfEmployee = new ElectricalWork("Address", PropertySize.LARGE, false, 7, 4,false);
    differentSize = new ElectricalWork("Address", PropertySize.MEDIUM, false, 7, 3,false);
    isNotComplex = new ElectricalWork("Address", PropertySize.LARGE, false, 7, 3,true);
    tooFewEmployee = new ElectricalWork("Address", PropertySize.LARGE, false, 7, 0,false);
    complexWorkForLarge = new ElectricalWork("Address", PropertySize.LARGE, false, 7, 1,true);
    complexWorkForSmall = new ElectricalWork("Address", PropertySize.SMALL, false, 7, 1,true);
  }

  @Test
  public void tooFewEmployee() {
    assertEquals(1, tooFewEmployee.getNumOfEmployee());
    assertEquals(2, complexWorkForSmall.getNumOfEmployee());
    assertEquals(3, complexWorkForLarge.getNumOfEmployee());
  }

  @Test
  public void calculatePrice() {
    assertEquals(650.0, electricalWork.calculatePrice(), 0.000001);
  }

  @Test(expected = InvalidNumOfEmployees.class)
  public void tooMuchEmployee() throws InvalidNumOfEmployees {
    ElectricalWork tooMuchEmployee = new ElectricalWork("Address", PropertySize.LARGE, false, 7, 5,false);
  }

  @Test
  public void isComplex() {
    assertFalse(electricalWork.isComplex());
  }

  @Test
  public void testEquals() {
    assertTrue(electricalWork.equals(equalWork));
    assertFalse(electricalWork.equals(differentNumOfEmployee));
    assertFalse(electricalWork.equals(differentSize));
    assertFalse(electricalWork.equals(isNotComplex));
  }

  @Test
  public void testHashCode() {
    assertTrue(electricalWork.hashCode() == electricalWork.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ElectricalWork: propertyAddress = Address, size = LARGE,"
        + " isMonthly = false, numOfServices = 7, numOfEmployee = 3, isComplex = false"
        , electricalWork.toString());
  }
}