package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ISetTest {
  ISet aSet;
  ISet empty;
  ISet same;
  ISet nullSet;
  ISet diffFirst;
  ISet diffRest;
  String diffType;

  @Before
  public void setUp() throws Exception {
    aSet = ISet.emptySet();
    aSet = aSet.add(1);
    empty = ISet.emptySet();
    same = ISet.emptySet();
    same = same.add(1);
    nullSet = null;
    diffType = "Set";
    diffFirst = ISet.emptySet();
    diffFirst = diffFirst.add(2);
    diffRest = aSet.add(2);
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(aSet.isEmpty());
  }

  @Test
  public void add() {
    ISet test = empty.add(1);
    assertEquals(aSet, test);
    ISet sameSet = aSet.add(1);
    assertEquals(aSet, sameSet);
  }

  @Test
  public void contains() {
    assertFalse(empty.contains(1));
    assertTrue(aSet.contains(1));
  }

  @Test
  public void remove() {
    ISet test = aSet.remove(1);
    assertEquals(empty, test);
    ISet sameEmpty = empty.remove(5);
    assertEquals(empty, sameEmpty);
    ISet testCons = aSet.remove(5);
    assertEquals(aSet, testCons);
  }

  @Test
  public void size() {
    assertEquals(Integer.valueOf(1), aSet.size());
  }

  @Test
  public void testEquals() {
    assertFalse(empty.equals(nullSet));
    assertFalse(empty.equals(diffType));
    assertTrue(aSet.equals(same));
    assertTrue(aSet.equals(aSet));
    assertFalse(aSet.equals(diffType));
    assertFalse(aSet.equals(diffFirst));
    assertFalse(aSet.equals(diffRest));
    assertFalse(aSet.equals(nullSet));
    aSet = aSet.add(2);
    ISet diffOrder = ISet.emptySet();
    diffOrder = diffOrder.add(2);
    diffOrder = diffOrder.add(1);
    assertTrue(aSet.equals(diffOrder));
  }

  @Test
  public void testHashCode() {
    assertTrue(aSet.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ConsSet{first=1, rest=EmptySet{}}", aSet.toString());
  }
}