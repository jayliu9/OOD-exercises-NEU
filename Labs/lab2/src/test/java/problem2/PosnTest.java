package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PosnTest {

  Posn onePosn;
  Posn equalPosn;
  Posn nullPosn;
  String wrongType;
  Posn nullX;
  Posn nullY;
  Posn equalNullX;
  Posn equalNullY;
  Posn nullXY;
  Posn equalNullXY;

  @Before
  public void setUp() throws Exception {
    onePosn = new Posn(15, 60);
    equalPosn = new Posn(15, 60);
    nullPosn = null;
    wrongType = "Posn{x=15, y=60}";
    nullX = new Posn(null, 60);
    nullY = new Posn(15, null);
    equalNullX = new Posn(null, 60);
    equalNullY = new Posn(15, null);
    nullXY = new Posn(null, null);
    equalNullXY = new Posn(null, null);
  }

  @Test
  public void testGetX() {
    assertEquals(Integer.valueOf(15), onePosn.getX());
  }

  @Test
  public void testGetY() {
    assertEquals(Integer.valueOf(60), onePosn.getY());
  }

  @Test
  public void testEquals() {
    assertTrue(onePosn.equals(equalPosn));
    assertTrue(onePosn.equals(onePosn));
    assertFalse(onePosn.equals(nullPosn));
    assertFalse(onePosn.equals(wrongType));
    assertFalse(onePosn.equals(nullX));
    assertFalse(onePosn.equals(nullY));
    assertFalse(nullX.equals(onePosn));
    assertTrue(nullXY.equals(equalNullXY));
    assertFalse(nullY.equals(onePosn));
  }

  @Test
  public void testHashCode() {
    assertTrue(onePosn.hashCode() == equalPosn.hashCode());
    assertTrue(onePosn.hashCode() != nullXY.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Posn{x=15, y=60}", onePosn.toString());
  }
}