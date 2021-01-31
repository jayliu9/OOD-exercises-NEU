package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SingleRoomTest {
  SingleRoom singleRoom;

  @Before
  public void setUp() throws Exception {
    singleRoom = new SingleRoom(24.5);
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(Integer.valueOf(1), singleRoom.getMaxOccupancy());
  }
}