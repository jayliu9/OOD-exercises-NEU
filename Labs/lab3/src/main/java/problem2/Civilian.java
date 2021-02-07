package problem2;

import java.util.Objects;

public class Civilian extends AbstractPiece {
  private Double wealth;

  public Civilian(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age);
    this.validateWealth(wealth);
    this.wealth = wealth;

  }

  @Override
  public void increase(Double num) throws InvalidWealthException {
    this.validateWealth(num);
    this.wealth += num;
  }

  @Override
  public void decrease(Double num) throws InvalidWealthException {
    this.validateWealth(num);
    this.validateWealthDecrease(num);
    this.wealth -= num;
  }

  private void validateWealth(Double wealth) throws InvalidWealthException {
    if (wealth <= 0) {
      throw new InvalidWealthException("Invalid wealth!");
    }
  }

  private void validateWealthDecrease(Double wealth) throws InvalidWealthException {
    if (wealth >= this.wealth) {
      throw new InvalidWealthException("The wealth to decrease is too much!");
    }
  }

  public Double getWealth() {
    return this.wealth;
  }

  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Civilian civilian = (Civilian) o;
    return this.wealth.equals(civilian.wealth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.wealth);
  }
}
