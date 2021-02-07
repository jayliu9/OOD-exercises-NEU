package problem2;

/**
 * Represents an engineer. Engineer is the subclass of Civilian.
 */
public class Engineer extends Civilian {

  /**
   * Constructor for the Engineer class
   * @param name The name of the engineer
   * @param age The age of the engineer
   * @param wealth The engineer's wealth
   * @throws InvalidAgeException if the age is invalid
   * @throws InvalidWealthException if the wealth is invalid
   */
  public Engineer(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age, wealth);
  }
}
