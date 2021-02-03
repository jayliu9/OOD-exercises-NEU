package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents a family room, which can sleep a maximum of 4 people. FamilyRoom is
 * the subclass of Room.
 */
public class FamilyRoom extends Room {

  private static final Integer FAMILY_OCCUPANCY = 4;

  /**
   * Constructor that creates a new FamilyRoom object. Its maximum occupancy is set to 4 by default.
   * @param price The cost of a single night’s stay. Must be greater than 0
   * @throws InvalidPriceException if the price is invalid
   */
  public FamilyRoom(Double price) throws InvalidPriceException {
    super(FAMILY_OCCUPANCY, price);
  }
}
