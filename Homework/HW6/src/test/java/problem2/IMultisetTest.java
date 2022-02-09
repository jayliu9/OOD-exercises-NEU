package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IMultisetTest {

  IMultiset aSet;
  IMultiset empty;
  IMultiset same;
  IMultiset diffSize;
  IMultiset diffItems;
  String diffType;
  IMultiset nullSet;
  IMultiset diffOrder;

  @Before
  public void setUp() throws Exception {

    aSet = new Empty();
    aSet = aSet.add("cat");
    aSet = aSet.add("tiger");
    aSet = aSet.add("cat");
    aSet = aSet.add("lion");
    empty = new Empty();
    IMultiset shared = new Empty();
    shared = shared.add("cat");
    shared = shared.add("tiger");
    shared = shared.add("cat");
    same = shared.add("lion");
    diffSize = same.add("dog");
    diffItems = shared.add("bird");
    diffType = "aSet";
    nullSet = null;
    diffOrder = new Empty();
    diffOrder = diffOrder.add("cat");
    diffOrder = diffOrder.add("lion");
    diffOrder = diffOrder.add("tiger");
    diffOrder = diffOrder.add("cat");
  }

  @Test
  public void count() {
    assertEquals(Integer.valueOf(0), empty.count());
    assertEquals(Integer.valueOf(4), aSet.count());
  }

  @Test
  public void add() {
    IMultiset addOne = empty.add("test");
    IMultiset test = new Empty();
    test = test.add("test");
    assertEquals(test, addOne);
  }

  @Test
  public void removeEmpty() {
    assertEquals(empty, empty.remove("cat"));
  }

  @Test
  public void removeNotContain() {
    assertEquals(aSet, aSet.remove("giraffe"));
  }

  @Test
  public void remove() {
    aSet = aSet.remove("tiger");
    aSet = aSet.remove("lion");
    aSet = aSet.remove("cat");
    IMultiset aCat = empty.add("cat");
    assertEquals(aCat, aSet);
  }

  @Test
  public void contains() {
    assertFalse(empty.contains("tiger"));
    assertTrue(aSet.contains("tiger"));
    assertFalse(aSet.contains("bird"));
  }

  @Test
  public void testEquals() {
    assertTrue(aSet.equals(same));
    assertTrue(aSet.equals(aSet));
    assertTrue(aSet.equals(diffOrder));
    assertFalse(aSet.equals(diffItems));
    assertFalse(aSet.equals(diffSize));
    assertFalse(aSet.equals(diffType));
    assertFalse(aSet.equals(nullSet));
  }

  @Test
  public void testHashCode() {
    assertTrue(aSet.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Cons{item='lion', rest="
        + "Cons{item='cat', rest="
        + "Cons{item='tiger', rest="
        + "Cons{item='cat', rest=Empty{}}}}}", aSet.toString());
  }
}