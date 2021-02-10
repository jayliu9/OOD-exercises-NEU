package problem1;

import java.util.Objects;

/**
 * Represents a interior service. InteriorService is the subclass of AbstractNonspecialist.
 */
public class InteriorService extends AbstractNonspecialist {

  private int numOfPets;
  private static final double FIVE_PERCENT_EXTRA_CHARGE = 0.05;
  private static final double SEVEN_PERCENT_EXTRA_CHARGE = 0.07;

  /**
   * Constructor for the InteriorService class.
   * @param propertyAddress The property address, represented as a String.
   * @param size The property size, represented as an enum.
   * @param isMonthly A boolean that indicates whether or not the service is carried out monthly.
   * @param numOfServices The number of services previous carried out at the address, represented
   *                      as an integer.
   * @param numOfPets The number of pets living at the address, represented as an integer.
   * @throws InvalidNumberOfPets if the number of pets is invalid.
   */
  public InteriorService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.validatePets(numOfPets);
    this.numOfPets = numOfPets;
  }

  /**
   * Gets the number of pets living at the address
   * @return The number of pets
   */
  public int getNumOfPets() {
    return this.numOfPets;
  }

  /**
   * Calculates the extra charge based on the number of pets.
   * @param basePrice The base price.
   * @return The extra charge of the service.
   */
  @Override
  protected double extraCharge(double basePrice) {
    switch (this.numOfPets) {
      case 0:
        return 0;
      case 1:
      case 2:
        return FIVE_PERCENT_EXTRA_CHARGE * basePrice;
      default:
        return SEVEN_PERCENT_EXTRA_CHARGE * basePrice;
    }
  }

  /**
   * Checks that the number of pets is valid
   * @param numOfPets The number of pets
   * @throws InvalidNumberOfPets if the number of pets is invalid
   */
  private void validatePets(int numOfPets) throws InvalidNumberOfPets {
    if (numOfPets < 0) {
      throw new InvalidNumberOfPets();
    }
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    InteriorService that = (InteriorService) o;
    return this.numOfPets == that.numOfPets;
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.numOfPets);
  }

  /**
   * Creates a string representation of the InteriorService.
   * @return a string representation of the InteriorService.
   */
  @Override
  public String toString() {
    return super.toString() + ", numOfPets = " + this.numOfPets;
  }
}
