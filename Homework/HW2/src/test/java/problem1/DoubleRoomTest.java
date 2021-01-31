package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoubleRoomTest {
  DoubleRoom doubleRoom;

  @Before
  public void setUp() throws Exception {
    doubleRoom = new DoubleRoom(33.8);
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(Integer.valueOf(2), doubleRoom.getMaxOccupancy());
  }
}