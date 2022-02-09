package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TripReportTest {

  TripReport test;
  TripReport same;
  TripReport nullReport;
  String differentType;
  TripReport differentVehicle;
  TripReport differentDistance;
  TripReport driveVersion2;
  TripReport driveVersion3;
  TripReport driveVersion4;

  @Before
  public void setUp() throws Exception {
    Bus bus = new Bus("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    Boat boat = new Boat("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    FleetManager fleetManager = new FleetManager();
    test = fleetManager.drive(600.0f, bus);
    same = fleetManager.drive(600.0f, bus);
    nullReport = null;
    differentType = "Report";
    differentVehicle = fleetManager.drive(600.0f, boat);
    differentDistance = fleetManager.drive(700.0f, bus);
    driveVersion2 = fleetManager.drive(boat, 18);
    driveVersion3 = fleetManager.drive(bus, 90.0f, 600.0f);
    driveVersion4 = fleetManager.drive(bus, 50.0f, 30);
  }

  @Test
  public void getVehicle() {
    Bus aBus = new Bus("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    assertEquals(aBus, test.getVehicle());
    Boat aBoat = new Boat("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
    assertEquals(aBoat, driveVersion2.getVehicle());
  }

  @Test
  public void getSpeed() {
    assertEquals(Float.valueOf(40.0f), test.getSpeed());
    assertEquals(Float.valueOf(80.0f), driveVersion3.getSpeed());
    assertEquals(Float.valueOf(50.0f), driveVersion4.getSpeed());
  }

  @Test
  public void getDistance() {
    assertEquals(Float.valueOf(600.0f), test.getDistance());
  }

  @Test
  public void getDuration() {
    assertEquals(Integer.valueOf(15), test.getDuration());
    assertEquals(Integer.valueOf(8), driveVersion3.getDuration());
  }

  @Test
  public void testEquals() {
    assertTrue(test.equals(same));
    assertTrue(test.equals(test));
    assertFalse(test.equals(nullReport));
    assertFalse(test.equals(differentType));
    assertFalse(test.equals(differentDistance));
    assertFalse(test.equals(differentVehicle));
    assertFalse(test.equals(driveVersion2));
    assertFalse(test.equals(driveVersion3));
    assertFalse(test.equals(driveVersion4));
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