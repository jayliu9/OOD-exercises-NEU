package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {

  Room availableRoom;

  @Before
  public void setUp() throws Exception {
    availableRoom = new Room(4, 50.0);
  }

  @Test
  public void bookRoom() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(3);
    assertEquals(Integer.valueOf(3), availableRoom.getGuestNum());
  }

  @Test
  public void isAvailable() {
    assertTrue(availableRoom.isAvailable());
  }

  @Test
  public void isNotAvailable() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(3);
    assertFalse(availableRoom.isAvailable());
  }

  @Test
  public void maxPeopleBookRoom() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(4);
    assertEquals(Integer.valueOf(4), availableRoom.getGuestNum());
  }

  @Test(expected = InvalidGuestNumException.class)
  public void tooManyGuestNum() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(5);
  }

  @Test(expected = InvalidGuestNumException.class)
  public void negativeGuestNum() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(-5);
  }

  @Test(expected = InvalidGuestNumException.class)
  public void zeroGuestNum() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(0);
  }

  @Test(expected = OccupiedRoomException.class)
  public void roomOccupied() throws InvalidGuestNumException, OccupiedRoomException {
    availableRoom.bookRoom(3);
    availableRoom.bookRoom(2);
  }

  @Test
  public void getMaxOccupancy() {
    assertEquals(Integer.valueOf(4), availableRoom.getMaxOccupancy());
  }

  @Test
  public void getPrice() {
    assertEquals(Double.valueOf(50.0), availableRoom.getPrice());
  }

  @Test
  public void getGuestNum() {
    assertEquals(Integer.valueOf(0), availableRoom.getGuestNum());
  }

  @Test(expected = InvalidPriceException.class)
  public void negativePrice() throws InvalidPriceException {
    Room invalidPrice = new Room(3, -10.5);
  }

  @Test(expected = InvalidPriceException.class)
  public void zeroPrice() throws InvalidPriceException {
    Room invalidPrice = new Room(3, 0.0);
  }
}