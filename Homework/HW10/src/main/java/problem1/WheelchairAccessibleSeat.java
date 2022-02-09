package problem1;

/**
 * Represents the wheelchair-accessible seat. This class extends Seat
 */
public class WheelchairAccessibleSeat extends Seat {

  private static final String EMPTY = "=";
  private static final String OCCUPIED = "X";

  /**
   * Constructor for the WheelchairAccessibleSeat class
   *
   * @param name The name of the wheelchair-accessible seat
   */
  public WheelchairAccessibleSeat(String name) {
    super(name);
  }

  /**
   * Creates a string representation of the WheelchairAccessibleSeat.
   *
   * @return a string representation of the WheelchairAccessibleSeat.
   */
  @Override
  public String toString() {
    if (this.getReserveFor() != null) {
      return OCCUPIED;
    }
    return EMPTY;
  }
}
