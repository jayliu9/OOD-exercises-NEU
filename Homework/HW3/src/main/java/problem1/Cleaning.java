package problem1;

public class Cleaning extends InteriorService {

  public Cleaning(String propertyAddress, PropertySize size, boolean isMonthly,
      int numOfServices, int numOfPets) throws InvalidNumberOfPets {
    super(propertyAddress, size, isMonthly, numOfServices, numOfPets);
  }
}
