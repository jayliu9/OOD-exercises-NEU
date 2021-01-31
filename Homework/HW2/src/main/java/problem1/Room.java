package problem1;

public class Room {

  private Integer maxOccupancy;
  private Float price;
  private Integer guestNum;
  private static final Integer INITIAL_VALUE = 0;

  public Room(Integer maxOccupancy, Float price) {
    this.maxOccupancy = maxOccupancy;
    this.price = price;
    this.guestNum = INITIAL_VALUE;
  }

  private boolean isAvailable () {
    return this.guestNum == 0;
  }

  public void bookRoom (Integer numOfGuest) throws OccupiedRoomException {
    if (!isAvailable()) {
      throw new OccupiedRoomException();
    }

  }
}
