package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyNodeTest {
  EmptyNode aNode;
  String diffType;
  EmptyNode nullNode;

  @Before
  public void setUp() throws Exception {
    aNode = new EmptyNode();
    diffType = "EmptyNode";
    nullNode = null;
  }

  @Test
  public void testEquals() {
    assertTrue(aNode.equals(aNode));
    assertFalse(aNode.equals(diffType));
    assertFalse(aNode.equals(nullNode));
  }
}