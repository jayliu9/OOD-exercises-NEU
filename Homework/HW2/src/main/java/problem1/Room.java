package problem1;

public class Room {

  private Integer maxOccupancy;
  private Double price;
  private Integer guestNum;
  private static final Integer INITIAL_VALUE = 0;

  public Room(Integer maxOccupancy, Double price) throws InvalidPriceException {
    this.maxOccupancy = maxOccupancy;
    this.validatePrice(price);
    this.price = price;
    this.guestNum = INITIAL_VALUE;
  }

  private void validatePrice(Double price) throws InvalidPriceException {
    if (price <= 0) {
      throw new InvalidPriceException();
    }
  }
  public boolean isAvailable () {
    return this.guestNum == 0;
  }

  private void validateAvailability() throws OccupiedRoomException {
    if (!isAvailable()) {
      throw new OccupiedRoomException();
    }
  }

  private void validateGuestNum(Integer guestNum) throws InvalidGuestNumException {
    if (guestNum <= 0 || guestNum > this.maxOccupancy) {
      throw new InvalidGuestNumException();
    }
  }

  public void bookRoom (Integer numOfGuest) throws OccupiedRoomException, InvalidGuestNumException {
    this.validateAvailability();
    this.validateGuestNum(numOfGuest);
    this.guestNum = numOfGuest;
  }

  public Integer getMaxOccupancy() {
    return this.maxOccupancy;
  }

  public Double getPrice() {
    return this.price;
  }

  public Integer getGuestNum() {
    return this.guestNum;
  }
}
