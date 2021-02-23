package problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TrainTest {

  Train train;

  @Before
  public void setUp() throws Exception {
    train = new Train("ID", Float.valueOf(70.0f), Float.valueOf(150.0f));
  }

  @Test
  public void testToString() {
    assertEquals("Train{ID=ID, averageSpeed=70.0, maxSpeed=150.0}", train.toString());
  }
}