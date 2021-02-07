package problem2;

public class Engineer extends Civilian {

  public Engineer(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age, wealth);
  }
}
