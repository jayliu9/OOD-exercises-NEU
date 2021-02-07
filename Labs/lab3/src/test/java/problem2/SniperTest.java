package problem2;

import static org.junit.Assert.*;

import org.junit.Test;

public class SniperTest {

  @Test
  public void createSniper() throws InvalidAgeException, InvalidStaminaException {
    Name name = new Name("Harry", "Potter");
    Sniper sniper = new Sniper(name, 25, 92.5);
  }
}