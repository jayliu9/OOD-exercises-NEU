package problem1;

public class DoubleRoom extends Room {

  private static final Integer DOUBLE_OCCUPANCY = 2;

  public DoubleRoom(Float price) {
    super(DOUBLE_OCCUPANCY, price);
  }
}
