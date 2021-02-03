package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5004
 * Course Number: 38097
 * Semester: Spring 2021
 *
 * This class represents a double room, which can sleep a maximum of 2 people. DoubleRoom is
 * the subclass of Room.
 */
public class DoubleRoom extends Room {

  private static final Integer DOUBLE_OCCUPANCY = 2;

  public DoubleRoom(Double price) throws InvalidPriceException {
    super(DOUBLE_OCCUPANCY, price);
  }
}
