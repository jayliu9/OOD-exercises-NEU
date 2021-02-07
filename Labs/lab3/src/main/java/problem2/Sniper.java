package problem2;

/**
 * Represents a sniper. Sniper is the subclass of Soldier.
 */
public class Sniper extends Soldier {

  /**
   * Constructor for the Sniper class
   * @param name The name of the sniper
   * @param age The age of the sniper
   * @param stamina The stamina of the sniper
   * @throws InvalidAgeException if the age is invalid
   * @throws InvalidStaminaException if the stamina is invalid
   */
  public Sniper(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age, stamina);
  }
}
