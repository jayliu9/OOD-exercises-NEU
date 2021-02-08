package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingTest {
  Painting test;
  Cleaning test2;
  InteriorService test3;

  @Before
  public void setUp() throws Exception {
    test = new Painting("A", PropertySize.LARGE, false, 5, 0);
    test2 = new Cleaning("A", PropertySize.LARGE, false, 5, 0);
    test3 = new InteriorService("A", PropertySize.SMALL, false, 5, 0);
  }

  @Test
  public void calculatePrice() {
    assertEquals(1920.0, test.calculatePrice(), 0.01);
    assertEquals(24, test.calculateMinInput());
    assertEquals(4, test2.calculateMinInput());
  }
}