package problem2;

/**
 * Represents a farmer. Farmer is the subclass of Civilian.
 */
public class Farmer extends Civilian {

  /**
   * Constructor for the Farmer class
   * @param name The name of the farmer
   * @param age The age of the farmer
   * @param wealth The farmer's wealth
   * @throws InvalidAgeException if the age is invalid
   * @throws InvalidWealthException if the wealth is invalid
   */
  public Farmer(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age, wealth);
  }
}
