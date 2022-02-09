package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeatTest {

  Seat seat;
  Seat same;
  Seat nullType;
  Seat diffName;
  String diffType;
  Seat diffReserveFor;

  @Before
  public void setUp() throws Exception {
    seat = new Seat("A");
    same = new Seat("A");
    nullType = null;
    diffName = new Seat("B");
    diffType = "Seat";
    diffReserveFor = new Seat("A");
    diffReserveFor.setReserveFor("Tony");
  }

  @Test
  public void getName() {
    assertEquals("A", seat.getName());
  }

  @Test
  public void testEquals() {
    assertTrue(seat.equals(same));
    assertTrue(seat.equals(seat));
    assertFalse(seat.equals(nullType));
    assertFalse(seat.equals(diffType));
    assertFalse(seat.equals(diffName));
    assertFalse(seat.equals(diffReserveFor));
  }

  @Test
  public void testHashCode() {
    assertTrue(seat.hashCode() == same.hashCode());
  }
}