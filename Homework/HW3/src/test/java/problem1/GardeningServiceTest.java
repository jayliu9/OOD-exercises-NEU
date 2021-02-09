package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningServiceTest {
  GardeningService gardening;

  @Before
  public void setUp() throws Exception {
    gardening = new GardeningService("Address", PropertySize.LARGE, false, 7);
  }

  @Test
  public void abc() {

  }
}