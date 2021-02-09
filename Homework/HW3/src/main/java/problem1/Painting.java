package problem1;

public class Painting extends InteriorService {
  private static final int HOURS_FOR_SMALL_AND_MEDIUM = 16;
  private static final int HOURS_FOR_LARGE = 24;

  public Painting(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices, numOfPets);
  }

  @Override
  protected int calculateMinInput() {
    switch (this.getSize()) {
      case SMALL:
      case MEDIUM:
        return HOURS_FOR_SMALL_AND_MEDIUM;
      default:
        return HOURS_FOR_LARGE;
    }
  }

  /**
   * Creates a string representation of the InteriorService.
   * @return a string representation of the InteriorService.
   */
  @Override
  public String toString() {
    return "Painting: " + super.toString();
  }
}
