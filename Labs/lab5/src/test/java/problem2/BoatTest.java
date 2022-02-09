package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoatTest {

  Boat boat;
  Boat same;
  Boat nullBoat;
  String differentType;
  Boat differentID;
  Boat differentAverageSpeed;
  Boat differentMaxSpeed;

  @Before
  public void setUp() throws Exception {
    boat = new Boat("ID", Float.valueOf(50.0f), Float.valueOf(100.0f));
    same = new Boat("ID", Float.valueOf(50.0f), Float.valueOf(100.0f));
    nullBoat = null;
    differentType = "Boat";
    differentID = new Boat("Different", Float.valueOf(50.0f), Float.valueOf(100.0f));
    differentAverageSpeed = new Boat("ID", Float.valueOf(45.0f), Float.valueOf(100.0f));
    differentMaxSpeed = new Boat("ID", Float.valueOf(50.0f), Float.valueOf(120.0f));
  }

  @Test
  public void getID() {
    assertEquals("ID", boat.getID());
  }

  @Test
  public void getAverageSpeed() {
    assertEquals(Float.valueOf(50.0f), boat.getAverageSpeed());
  }

  @Test
  public void getMaxSpeed() {
    assertEquals(Float.valueOf(100.0f), boat.getMaxSpeed());
  }

  @Test
  public void testEquals() {
    assertTrue(boat.equals(boat));
    assertTrue(boat.equals(same));
    assertFalse(boat.equals(nullBoat));
    assertFalse(boat.equals(differentAverageSpeed));
    assertFalse(boat.equals(differentID));
    assertFalse(boat.equals(differentMaxSpeed));
    assertFalse(boat.equals(differentType));
  }

  @Test
  public void testHashCode() {
    assertTrue(boat.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Boat{ID=ID, averageSpeed=50.0, maxSpeed=100.0}", boat.toString());
  }
}