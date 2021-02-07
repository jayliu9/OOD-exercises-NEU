package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class VegetableTest {

  @Test
  public void createVegetable() throws StorageExcessException, SpoilageException {
    Vegetable vegetable = new Vegetable("Vegetable", 1.8, 30, 5, 10);
  }

}