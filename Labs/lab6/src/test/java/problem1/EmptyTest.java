package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyTest {
  List empty;
  String diffType;
  List nullEmpty;

  @Before
  public void setUp() throws Exception {
    empty = List.createList();
    diffType = "Empty";
    nullEmpty = null;
  }

  @Test(expected = InvalidCallException.class)
  public void invalidCallLast() {
    empty.last();
  }

  @Test(expected = InvalidCallException.class)
  public void invalidCallElementAt() {
    empty.elementAt(0);
  }

  @Test
  public void testEquals() {
    assertTrue(empty.equals(empty));
    assertFalse(empty.equals(diffType));
    assertFalse(empty.equals(nullEmpty));
  }
}