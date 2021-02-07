package problem2;

public class Farmer extends Civilian {

  public Farmer(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age, wealth);
  }
}
