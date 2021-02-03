package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents Room with the maximum occupancy, price, and number of guests.
 */
public class Room {

  private Integer maxOccupancy;
  private Double price;
  private Integer guestNum;
  private static final Integer INITIAL_VALUE = 0;

  /**
   * Constructor that creates a new Room object with the given maximum occupancy, price.
   * The number of guests currently booked into the room. This value should be 0 when the room
   * is first created in the system.
   * @param maxOccupancy The maximum number of people that can stay in the room.
   * @param price The cost of a single night’s stay. Must be greater than 0
   */
  public Room(Integer maxOccupancy, Double price) throws InvalidPriceException {
    this.maxOccupancy = maxOccupancy;
    this.validatePrice(price);
    this.price = price;
    this.guestNum = INITIAL_VALUE;
  }

  /**
   * Checks that the price is valid. Throws an exception if the price is invalid.
   * @param price The price to check
   * @throws InvalidPriceException
   */
  private void validatePrice(Double price) throws InvalidPriceException {
    if (price <= 0) {
      throw new InvalidPriceException();
    }
  }

  /**
   * Checks if the room is available or not.
   * @return true if the room is available, false otherwise.
   */
  public boolean isAvailable() {
    return this.guestNum == 0;
  }

  /**
   * Checks that the room is currently available. Throws an exception if the room is not available.
   * @throws OccupiedRoomException
   */
  private void validateAvailability() throws OccupiedRoomException {
    if (!isAvailable()) {
      throw new OccupiedRoomException();
    }
  }

  /**
   * Checks that The number of guests is valid. Throws an exception if the number of guests
   * is invalid.
   * @param guestNum The number of guests that would like to stay in a room.
   * @throws InvalidGuestNumException
   */
  private void validateGuestNum(Integer guestNum) throws InvalidGuestNumException {
    if (guestNum <= 0 || guestNum > this.maxOccupancy) {
      throw new InvalidGuestNumException();
    }
  }

  /**
   * Books this Room.
   * @param numOfGuest The number of guests that would like to stay in this room
   * @throws OccupiedRoomException
   * @throws InvalidGuestNumException
   */
  public void bookRoom(Integer numOfGuest) throws OccupiedRoomException, InvalidGuestNumException {
    this.validateAvailability();
    this.validateGuestNum(numOfGuest);
    this.guestNum = numOfGuest;
  }

  /**
   * Gets the maximum occupancy of this Room
   * @return The maximum occupancy of this Room
   */
  public Integer getMaxOccupancy() {
    return this.maxOccupancy;
  }

  /**
   * Gets the price of this Room
   * @return The price of this Room
   */
  public Double getPrice() {
    return this.price;
  }

  /**
   * Gets the number of guests currently booked into the room.
   * @return The number of guests currently booked into the room.
   */
  public Integer getGuestNum() {
    return this.guestNum;
  }
}
