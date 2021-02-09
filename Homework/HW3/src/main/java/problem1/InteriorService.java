package problem1;

import java.util.Objects;

public class InteriorService extends AbstractNonspecialist {
  private int numOfPets;
  private static final double FIVE_PERCENT_EXTRA_CHARGE = 0.05;
  private static final double SEVEN_PERCENT_EXTRA_CHARGE = 0.07;

  public InteriorService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.validatePets(numOfPets);
    this.numOfPets = numOfPets;
  }


  public int getNumOfPets() {
    return this.numOfPets;
  }

  public void setNumOfPets(int numOfPets) {
    this.numOfPets = numOfPets;
  }

  @Override
  protected double extraCharge(double price) {
    switch (this.numOfPets) {
      case 0:
        return 0;
      case 1:
      case 2:
        return FIVE_PERCENT_EXTRA_CHARGE * price;
      default:
        return SEVEN_PERCENT_EXTRA_CHARGE * price;
    }
  }

  private void validatePets(int numOfPets) throws InvalidNumberOfPets {
    if (numOfPets < 0) {
      throw new InvalidNumberOfPets();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    InteriorService that = (InteriorService) o;
    return this.numOfPets == that.numOfPets;
  }

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
