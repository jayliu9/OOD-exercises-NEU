package problem2;

import java.util.Objects;

public class Soldier extends AbstractPiece {
  private Double stamina;
  private static final Double MAX_STAMINA = 100.0;

  public Soldier(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age);
    this.validateStamina(stamina);
    this.stamina = stamina;
  }

  @Override
  public void increase(Double num) throws InvalidStaminaException {
    validateStamina(num);
    validateStaminaIncrease(num);
    this.stamina += num;
  }

  @Override
  public void decrease(Double num) throws InvalidStaminaException {
    validateStamina(num);
    validateStaminaDecrease(num);
    this.stamina -= num;
  }

  private void validateStamina(Double stamina) throws InvalidStaminaException {
    if (stamina < 0 || stamina >= MAX_STAMINA) {
      throw new InvalidStaminaException("Invalid stamina!");
    }
  }

  private void validateStaminaIncrease(Double stamina) throws InvalidStaminaException {
    Double increaseResult = stamina + this.stamina;
    if (increaseResult > MAX_STAMINA) {
      throw new InvalidStaminaException("The stamina to increase is too much!");
    }
  }

  private void validateStaminaDecrease(Double stamina) throws InvalidStaminaException {
    Double decreaseResult = this.stamina - stamina;
    if (decreaseResult < 0) {
      throw new InvalidStaminaException("The stamina to decrease is too much!");
    }
  }

  public Double getStamina() {
    return this.stamina;
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Soldier soldier = (Soldier) o;
    return this.stamina.equals(soldier.stamina);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.stamina);
  }
}
