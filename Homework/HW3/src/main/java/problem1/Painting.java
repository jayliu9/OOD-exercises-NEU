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
        return this.HOURS_FOR_SMALL_AND_MEDIUM;
      default:
        return this.HOURS_FOR_LARGE;
    }
  }

  protected void abc(){
  }
}
