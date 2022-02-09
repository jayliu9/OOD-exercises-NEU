package problem1;

/**
 * Represents a cleaning. Cleaning is the subclass of InteriorService.
 */
public class Cleaning extends InteriorService {

  /**
   * Constructor for the Cleaning class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   * @param numOfPets The number of pets living at the address, represented as an integer.
   * @throws InvalidNumberOfPets if the number of pets is invalid
   */
  public Cleaning(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices, numOfPets);
  }

  /**
   * Creates a string representation of the Cleaning.
   * @return a string representation of the Cleaning.
   */
  @Override
  public String toString() {
    return "Cleaning: " + super.toString();
  }
}
