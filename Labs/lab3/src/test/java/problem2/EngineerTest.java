package problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class EngineerTest {

  @Test
  public void createEngineer() throws InvalidAgeException, InvalidWealthException {
    Name name = new Name("Harry", "Potter");
    Engineer engineer = new Engineer(name, 25, 35000.0);
  }
}