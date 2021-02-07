package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RiceTest {

  Rice rice;

  @Before
  public void setUp() throws Exception {
    rice = new Rice("Rice", 1.0, 200);
  }

  @Test
  public void getMax() {
    assertEquals(Integer.valueOf(250), rice.getMAX());
  }
}