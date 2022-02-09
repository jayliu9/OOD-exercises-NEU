package problem1;

/**
 * Represents a painting. Painting is the subclass of InteriorService.
 */
public class Painting extends InteriorService {

  private static final int HOURS_FOR_SMALL_AND_MEDIUM = 16;
  private static final int HOURS_FOR_LARGE = 24;

  /**
   * Constructor for the Painting class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   * @param numOfPets The number of pets living at the address, represented as an integer.
   * @throws InvalidNumberOfPets if the number of pets is invalid.
   */
  public Painting(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices, numOfPets);
  }

  /**
   * Calculates the hours required to complete the painting service according to the property size.
   * @return the required hours.
   */
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
   * Creates a string representation of the Painting.
   * @return a string representation of the Painting.
   */
  @Override
  public String toString() {
    return "Painting: " + super.toString();
  }
}
