package problem2;

/**
 * Represents a marine. Marine is the subclass of Soldier.
 */
public class Marine extends Soldier {

  /**
   * Constructor for the Marine class
   * @param name The name of the marine
   * @param age The age of the marine
   * @param stamina The stamina of the marine
   * @throws InvalidAgeException if the age is invalid
   * @throws InvalidStaminaException if the stamina is invalid
   */
  public Marine(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age, stamina);
  }
}
