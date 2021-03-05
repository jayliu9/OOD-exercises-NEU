package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyTest {
  Empty empty;
  Empty nullType;
  String diffType;

  @Before
  public void setUp() throws Exception {
    empty = new Empty();
    nullType = null;
    diffType = "empty";
  }

  @Test
  public void testEquals() {
    assertFalse(empty.equals(nullType));
    assertFalse(empty.equals(diffType));
  }
}