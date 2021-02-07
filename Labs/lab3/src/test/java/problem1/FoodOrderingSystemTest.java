package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoodOrderingSystemTest {
  FoodOrderingSystem system;
  static final int MAXSIZE = 10;

  @Before
  public void setUp() throws Exception {
    Food[] list = new Food[MAXSIZE];
    list[0] = new Rice("Rice", 1.0, 200);
    system = new FoodOrderingSystem(list);
  }

  @Test
  public void getFoodList() {
    assertEquals("Rice", system.getFoodList()[0].getName());
    assertEquals(Double.valueOf(1.0), system.getFoodList()[0].getPricePerUnit());
    assertEquals(Integer.valueOf(200), system.getFoodList()[0].getAvailableQuantity());
    assertEquals(Integer.valueOf(250), system.getFoodList()[0].getMAX());
  }
}