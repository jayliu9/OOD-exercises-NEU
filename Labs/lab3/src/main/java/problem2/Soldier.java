package problem2;

import java.util.Objects;

/**
 * Represents a soldier. Soldier is the subclass of AbstractPiece.
 */
public class Soldier extends AbstractPiece {
  private Double stamina;
  private static final Double MAX_STAMINA = 100.0;

  /**
   * Constructor for the Soldier class
   * @param name The name of the soldier
   * @param age The age of the soldier
   * @param stamina The stamina of the soldier
   * @throws InvalidAgeException if the age is invalid
   * @throws InvalidStaminaException if the stamina is invalid
   */
  public Soldier(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age);
    this.validateStamina(stamina);
    this.stamina = stamina;
  }

  /**
   * Performs an increase in the soldier's stamina
   * @param num The amount of stamina to increase by
   * @throws InvalidStaminaException if the amount is invalid
   */
  @Override
  public void increase(Double num) throws InvalidStaminaException {
    validateStaminaIncrease(num);
    this.stamina += num;
  }

  /**
   * Performs a decrease in the soldier's stamina
   * @param num The amount of stamina to decrease by
   * @throws InvalidStaminaException if the amount is invalid
   */
  @Override
  public void decrease(Double num) throws InvalidStaminaException {
    validateStaminaDecrease(num);
    this.stamina -= num;
  }

  /**
   * Checks that the stamina is valid
   * @param stamina The stamina to check
   * @throws InvalidStaminaException if the stamina is invalid
   */
  private void validateStamina(Double stamina) throws InvalidStaminaException {
    if (stamina < 0 || stamina >= MAX_STAMINA) {
      throw new InvalidStaminaException("Invalid stamina!");
    }
  }

  /**
   * Checks that the increase of the stamina is valid
   * @param stamina The increase of the stamina to check
   * @throws InvalidStaminaException if the increase of the stamina is invalid
   */
  private void validateStaminaIncrease(Double stamina) throws InvalidStaminaException {
    this.validateStamina(stamina);
    Double increaseResult = stamina + this.stamina;
    if (increaseResult > MAX_STAMINA) {
      throw new InvalidStaminaException("The stamina to increase is too much!");
    }
  }

  /**
   * Checks that the decrease of the stamina is valid
   * @param stamina The decrease of the stamina to check
   * @throws InvalidStaminaException if the decrease of the stamina is invalid
   */
  private void validateStaminaDecrease(Double stamina) throws InvalidStaminaException {
    this.validateStamina(stamina);
    Double decreaseResult = this.stamina - stamina;
    if (decreaseResult < 0) {
      throw new InvalidStaminaException("The stamina to decrease is too much!");
    }
  }

  /**
   * Gets the stamina of the soldier
   * @return The stamina of the soldier
   */
  public Double getStamina() {
    return this.stamina;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Soldier soldier = (Soldier) o;
    return this.stamina.equals(soldier.stamina);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.stamina);
  }
}
