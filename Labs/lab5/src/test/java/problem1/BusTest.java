package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BusTest {

  Bus bus;

  @Before
  public void setUp() throws Exception {
    bus = new Bus("ID", Float.valueOf(40.0f), Float.valueOf(80.0f));
  }

  @Test
  public void testToString() {
    assertEquals("Bus{ID=ID, averageSpeed=40.0, maxSpeed=80.0}", bus.toString());
  }
}