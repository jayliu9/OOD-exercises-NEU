package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripReportTest {

  TripReport test;
  TripReport same;
  TripReport nullReport;
  String differentType;
  TripReport differentVehicle;
  TripReport differentSpeed;
  TripReport differentDistance;
  TripReport differentDuration;

  @Before
  public void setUp() throws Exception {
    Bus bus = new Bus("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    Boat boat = new Boat("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    Bus quickBus = new Bus("ID", Float.valueOf(50.0f), Float.valueOf(90.0f));
    FleetManager fleetManager = new FleetManager();
    test = fleetManager.drive(600.0f, bus);
    same = fleetManager.drive(600.0f, bus);
    nullReport = null;
    differentType = "Report";
    differentVehicle = fleetManager.drive(600.0f, boat);
    differentSpeed = fleetManager.drive(600.0f, quickBus);
    differentDistance = fleetManager.drive(700.0f, bus);
    differentDuration = fleetManager.drive(800.0f, bus);
  }

  @Test
  public void getVehicle() {
    Bus aBus = new Bus("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    assertEquals(aBus, test.getVehicle());
  }

  @Test
  public void getSpeed() {
    assertEquals(Float.valueOf(40.0f), test.getSpeed());
  }

  @Test
  public void getDistance() {
    assertEquals(Float.valueOf(600.0f), test.getDistance());
  }

  @Test
  public void getDuration() {
    assertEquals(Integer.valueOf(15), test.getDuration());
  }

  @Test
  public void testEquals() {
    assertTrue(test.equals(same));
    assertTrue(test.equals(test));
    assertFalse(test.equals(nullReport));
    assertFalse(test.equals(differentType));
    assertFalse(test.equals(differentDistance));
    assertFalse(test.equals(differentSpeed));
    assertFalse(test.equals(differentVehicle));
    assertFalse(test.equals(differentDuration));
  }

  @Test
  public void testHashCode() {
    assertTrue(test.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("TripReport{vehicle=Bus{ID=ID, averageSpeed=40.0, maxSpeed=80.0}, " +
        "speed=40.0, distance=600.0, duration=15}", test.toString());
  }
}