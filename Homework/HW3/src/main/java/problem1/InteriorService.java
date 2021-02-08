package problem1;

public class InteriorService extends AbstractNonspecialist {
  private int numOfPets;
  private double FIVE_PERCENT_EXTRA_CHARGE = 0.05;
  private double SEVEN_PERCENT_EXTRA_CHARGE = 0.07;

  public InteriorService(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices);
    this.validatePets(numOfPets);
    this.numOfPets = numOfPets;
  }


  public int getNumOfPets() {
    return this.numOfPets;
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
}
