package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MeatTest {
  Meat meat;

  @Before
  public void setUp() throws Exception {
    meat = new Meat("Meat", 3.50, 59,20, 30);
  }

  @Test
  public void getName() {
    assertEquals("Meat", meat.getName());
  }

  @Test
  public void getPricePerUnit() {
    assertEquals(Double.valueOf(3.50), meat.getPricePerUnit());
  }

  @Test
  public void getAvailableQuantity() {
    assertEquals(Integer.valueOf(59), meat.getAvailableQuantity());
  }

  @Test
  public void getOrderDate() {
    assertEquals(Integer.valueOf(20), meat.getOrderDate());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(Integer.valueOf(30), meat.getExpirationDate());
  }

  @Test(expected = StorageExcessException.class)
  public void invalidStorage() throws StorageExcessException, SpoilageException {
    Meat overMaximum = new Meat("Meat", 3.50, 159, 20, 30);
  }

  @Test(expected = SpoilageException.class)
  public void expiredFood() throws StorageExcessException, SpoilageException {
    Meat expiredMeat = new Meat("Meat", 3.50, 59, 50, 30);
  }
}