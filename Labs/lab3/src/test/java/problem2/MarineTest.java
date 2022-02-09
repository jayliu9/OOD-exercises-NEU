package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MarineTest {

  Marine marine;
  Name name;
  Marine equalMarine;
  String differentClass;
  Marine differentStamina;
  Marine nullMarine;
  Marine differentAge;

  @Before
  public void setUp() throws Exception {
    name = new Name("Harry", "Potter");
    marine = new Marine(name, 25, 90.0);
    equalMarine = new Marine(name, 25, 90.0);
    differentClass = "Harry Potter";
    differentStamina = new Marine(name, 25, 85.0);
    differentAge = new Marine(name, 35, 85.0);
    nullMarine = null;
  }

  @Test
  public void getName() {
    Name test = new Name("Harry", "Potter");
    assertEquals(test, marine.getName());
  }

  @Test
  public void getAge() {
    assertEquals(Integer.valueOf(25), marine.getAge());
  }

  @Test
  public void getStamina() {
    assertEquals(Double.valueOf(90.0), marine.getStamina());
  }

  @Test
  public void increase() throws InvalidStaminaException {
    marine.increase(5.5);
    assertEquals(Double.valueOf(95.5), marine.getStamina());
  }

  @Test
  public void decrease() throws InvalidStaminaException {
    marine.decrease((25.5));
    assertEquals(Double.valueOf(64.5), marine.getStamina());
  }

  @Test(expected = InvalidStaminaException.class)
  public void tooMuchStamina() throws InvalidAgeException, InvalidStaminaException {
    Marine tooMuch = new Marine(name, 25, 105.7);
  }

  @Test(expected = InvalidStaminaException.class)
  public void negativeStamina() throws InvalidAgeException, InvalidStaminaException {
    Marine negative = new Marine(name, 25, -7.8);
  }

  @Test(expected = InvalidStaminaException.class)
  public void invalidDecrease() throws InvalidStaminaException {
    marine.decrease(96.5);
  }

  @Test(expected = InvalidStaminaException.class)
  public void invalidIncrease() throws InvalidStaminaException {
    marine.increase(20.0);
  }

  @Test
  public void testEquals() {
    assertTrue(marine.equals(equalMarine));
    assertFalse(marine.equals(differentStamina));
    assertFalse(marine.equals(differentAge));
    assertTrue(marine.equals(marine));
    assertFalse(marine.equals(differentClass));
    assertFalse(marine.equals(nullMarine));
  }

  @Test
  public void testHashCode() {
    assertTrue(marine.hashCode() == equalMarine.hashCode());
  }
}