package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FruitTest {

  @Test
  public void createFruit() throws StorageExcessException, SpoilageException {
    Fruit fruit = new Fruit("Fruit", 2.1, 25, 3, 7);
  }

}