package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents a single room, which can sleep a maximum of 1 person only. SingleRoom is
 * the subclass of Room.
 */
public class SingleRoom extends Room {

  private static final Integer ONE_PERSON_ONLY = 1;

  /**
   * Constructor that creates a new SingleRoom object. Its maximum occupancy is set to 1 by default.
   * @param price The cost of a single night’s stay. Must be greater than 0
   * @throws InvalidPriceException if the price is invalid
   */
  public SingleRoom(Double price) throws InvalidPriceException {
    super(ONE_PERSON_ONLY, price);
  }
}
