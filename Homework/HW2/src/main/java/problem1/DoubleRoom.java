package problem1;

public class DoubleRoom extends Room {

  private static final Integer DOUBLE_OCCUPANCY = 2;

  public DoubleRoom(Double price) throws InvalidPriceException {
    super(DOUBLE_OCCUPANCY, price);
  }
}
