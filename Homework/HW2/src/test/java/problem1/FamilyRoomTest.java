package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FamilyRoomTest {

  FamilyRoom familyRoom;

  @Before
  public void setUp() throws Exception {
    familyRoom = new FamilyRoom(48.5);
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(Integer.valueOf(4), familyRoom.getMaxOccupancy());
  }
}