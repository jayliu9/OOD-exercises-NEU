package problem2;

import java.util.Objects;

/**
 * Represents a civilian. Civilian is the subclass of AbstractPiece.
 */
public class Civilian extends AbstractPiece {
  private Double wealth;

  /**
   * Constructor for the Civilian class
   * @param name The name of the civilian
   * @param age The age of the civilian
   * @param wealth The wealth of the civilian
   * @throws InvalidAgeException if the age is invalid
   * @throws InvalidWealthException if the wealth is invalid.
   */
  public Civilian(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age);
    this.validateWealth(wealth);
    this.wealth = wealth;
  }

  /**
   * Performs an increase in the civilian's wealth.
   * @param num The amount of wealth to increase by
   * @throws InvalidWealthException if the amount is invalid
   */
  @Override
  public void increase(Double num) throws InvalidWealthException {
    this.validateWealth(num);
    this.wealth += num;
  }

  /**
   * Performs a decrease in the civilian's wealth.
   * @param num The amount of wealth to decrease by
   * @throws InvalidWealthException if the amount is invalid
   */
  @Override
  public void decrease(Double num) throws InvalidWealthException {
    this.validateWealthDecrease(num);
    this.wealth -= num;
  }

  /**
   * Checks that the wealth is valid
   * @param wealth The wealth to check
   * @throws InvalidWealthException if the wealth is invalid
   */
  private void validateWealth(Double wealth) throws InvalidWealthException {
    if (wealth <= 0) {
      throw new InvalidWealthException("Invalid wealth!");
    }
  }

  /**
   * Checks that the decrease of the wealth is valid
   * @param wealth The decrease of the wealth to check
   * @throws InvalidWealthException if the decrease of wealth is invalid
   */
  private void validateWealthDecrease(Double wealth) throws InvalidWealthException {
    this.validateWealth(wealth);
    if (wealth >= this.wealth) {
      throw new InvalidWealthException("The wealth to decrease is too much!");
    }
  }

  /**
   * Gets the wealth of the civilian
   * @return The wealth of the civilian
   */
  public Double getWealth() {
    return this.wealth;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Civilian civilian = (Civilian) o;
    return this.wealth.equals(civilian.wealth);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.wealth);
  }
}
