package problem1;

public class FamilyRoom extends Room {

  private static final Integer FAMILY_OCCUPANCY = 4;

  public FamilyRoom(Double price) throws InvalidPriceException {
    super(FAMILY_OCCUPANCY, price);
  }
}
