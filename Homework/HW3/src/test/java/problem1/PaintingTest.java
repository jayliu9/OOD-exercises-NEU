package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {
  Painting largeProperty;
  Painting mediumProperty;
  Painting fiftyPercentOff;
  Painting tenPercentOff;
  Painting equalPainting;
  Painting nullPainting;
  Painting isMonthly;
  Painting differentAddress;
  Painting differentNumOfServices;
  Painting threePets;
  String differentType;
  Painting onePet;

  @Before
  public void setUp() throws Exception {
    largeProperty = new Painting("Address", PropertySize.LARGE, false, 5, 0);
    mediumProperty = new Painting("Address", PropertySize.MEDIUM, false, 5, 0);
    fiftyPercentOff = new Painting("Address", PropertySize.LARGE, false, 9, 0);
    tenPercentOff = new Painting("Address", PropertySize.LARGE, true, 18, 0);
    equalPainting = new Painting("Address", PropertySize.LARGE, false, 5, 0);
    nullPainting = null;
    isMonthly = new Painting("Address", PropertySize.LARGE, true, 5, 0);
    differentAddress = new Painting("A", PropertySize.LARGE, false, 5, 0);
    differentNumOfServices = new Painting("Address", PropertySize.LARGE, false, 12, 0);
    threePets = new Painting("Address", PropertySize.LARGE, false, 5, 3);
    differentType = "Painting";
    onePet = new Painting("A", PropertySize.LARGE, false, 5, 1);
  }

  @Test
  public void calculatePrice() {
    assertEquals(1920.0, largeProperty.calculatePrice(), 0.000001);
    assertEquals(1280.0, mediumProperty.calculatePrice(), 0.000001);
    assertEquals(960.0, fiftyPercentOff.calculatePrice(), 0.000001);
    assertEquals(1728.0, tenPercentOff.calculatePrice(), 0.000001);
  }

  @Test
  public void withPets() {
    assertEquals(2016.0, onePet.calculatePrice(), 0.000001);
    assertEquals(2054.4, threePets.calculatePrice(), 0.000001);
  }

  @Test
  public void getAddress() {
    assertEquals("Address", largeProperty.getPropertyAddress());
  }

  @Test
  public void isMonthly() {
    assertFalse(largeProperty.isMonthly());
  }

  @Test
  public void getSize() {
    assertEquals(PropertySize.LARGE, largeProperty.getSize());
  }

  @Test
  public void getNumOfService() {
    assertEquals(5, largeProperty.getNumOfServices());
  }

  @Test
  public void testEquals() {
    assertFalse(largeProperty.equals(differentAddress));
    assertFalse(largeProperty.equals(differentNumOfServices));
    assertTrue(largeProperty.equals(equalPainting));
    assertFalse(largeProperty.equals(threePets));
    assertFalse(largeProperty.equals(isMonthly));
    assertFalse(largeProperty.equals(differentType));
    assertFalse(largeProperty.equals(nullPainting));
    assertTrue(largeProperty.equals(largeProperty));
    assertFalse(largeProperty.equals(mediumProperty));

  }

  @Test
  public void testHashCode() {
    assertTrue(largeProperty.hashCode() == equalPainting.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Painting: propertyAddress = Address, size = LARGE,"
        + " isMonthly = false, numOfServices = 5, numOfPets = 0", largeProperty.toString());
  }

  @Test
  public void getNumOfPets() {
    assertEquals(0, largeProperty.getNumOfPets());
  }

  @Test(expected = InvalidNumberOfPets.class)
  public void invalidNumOfPets() throws InvalidNumberOfPets {
    Painting invalidNumOfPets = new Painting("Address", PropertySize.LARGE, false, 5, -1);
  }
}