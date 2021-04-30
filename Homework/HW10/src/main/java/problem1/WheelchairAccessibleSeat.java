package problem1;

public class WheelchairAccessibleSeat extends Seat {

  private static final String EMPTY = "=";
  private static final String OCCUPIED = "X";

  public WheelchairAccessibleSeat(String name) {
    super(name);
  }

  @Override
  public String toString() {
    if (this.getReserveFor() != null)
      return OCCUPIED;
    return EMPTY;
  }
}
