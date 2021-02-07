package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FarmerTest {
  Farmer farmer;
  Name name;
  Farmer equalFarmer;
  Farmer differentName;
  Farmer differentWealth;

  @Before
  public void setUp() throws Exception {
    name = new Name("Harry", "Potter");
    Name newName = new Name("A", "B");
    farmer = new Farmer(name, 25, 24000.0);
    equalFarmer = new Farmer(name, 25, 24000.0);
    differentName = new Farmer(newName, 25, 24000.0);
    differentWealth = new Farmer(name, 25, 26000.0);
  }

  @Test
  public void increase() throws InvalidWealthException {
    farmer.increase(6000.0);
    assertEquals(Double.valueOf(30000.0), farmer.getWealth());
  }

  @Test
  public void decrease() throws InvalidWealthException {
    farmer.decrease(14000.0);
    assertEquals(Double.valueOf(10000.0), farmer.getWealth());
  }

  @Test(expected = InvalidWealthException.class)
  public void negativeWealth() throws InvalidAgeException, InvalidWealthException {
    Farmer negative = new Farmer(name, 25, -1234.5);
  }

  @Test(expected = InvalidWealthException.class)
  public void invalidDecrease() throws InvalidWealthException {
    farmer.decrease(25000.0);
  }

  @Test
  public void testEquals() {
    assertTrue(farmer.equals(equalFarmer));
    assertFalse(farmer.equals(differentWealth));
    assertFalse(farmer.equals(differentName));
  }

  @Test
  public void testHashCode() {
    assertTrue(farmer.hashCode() == equalFarmer.hashCode());
  }

  @Test(expected = InvalidAgeException.class)
  public void tooOld() throws InvalidAgeException, InvalidWealthException {
    Farmer tooOld = new Farmer(name, 129, 10000.0);
  }

  @Test(expected = InvalidAgeException.class)
  public void negativeAge() throws InvalidAgeException, InvalidWealthException {
    Farmer negativeAge = new Farmer(name, -1, 10000.0);
  }
}