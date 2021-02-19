package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
  ISet aSet;
  ISet empty;
  ISet sameSet;
  String differentType;
  ISet nullSet;
  ISet differentItems;

  @Before
  public void setUp() throws Exception {
    empty = Set.emptySet();
    aSet = Set.emptySet();
    aSet = aSet.add(1);
    aSet = aSet.add(2);
    aSet = aSet.add(3);
    aSet = aSet.add(4);
    sameSet = Set.emptySet();
    sameSet = sameSet.add(2);
    sameSet = sameSet.add(3);
    sameSet = sameSet.add(1);
    sameSet = sameSet.add(4);
    differentType = "Set";
    nullSet = null;
    differentItems = Set.emptySet();
    differentItems = differentItems.add(5);
    differentItems = differentItems.add(6);
    differentItems = differentItems.add(1);
    differentItems = differentItems.add(2);
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(aSet.isEmpty());
  }

  @Test
  public void add() {
    empty = empty.add(1);
    ISet test = Set.emptySet();
    test = test.add(1);
    assertEquals(test, empty);

  }
  @Test
  public void addDuplicate() {
    aSet = aSet.add(3);
    ISet test = Set.emptySet();
    test = test.add(1);
    test = test.add(2);
    test = test.add(3);
    test = test.add(4);
    assertEquals(test, aSet);
  }

  @Test
  public void contains() {
    assertTrue(aSet.contains(1));
    assertFalse(aSet.contains(5));
  }

  @Test
  public void remove() {
    aSet = aSet.add(5);
    aSet = aSet.add(6);
    aSet = aSet.remove(2);
    aSet = aSet.remove(4);
    ISet test = Set.emptySet();
    test = test.add(5);
    test = test.add(1);
    test = test.add(3);
    test = test.add(6);
    assertEquals(test, aSet);
  }

  @Test
  public void removeNotFound() {
    aSet = aSet.remove(5);
    ISet test = Set.emptySet();
    test = test.add(1);
    test = test.add(2);
    test = test.add(3);
    test = test.add(4);
    assertEquals(test, aSet);
  }

  @Test
  public void size() {
    assertTrue(empty.size() == 0);
    assertTrue(aSet.size() == 4);
  }

  @Test
  public void testEquals() {
    assertTrue(aSet.equals(aSet));
    assertTrue(aSet.equals(sameSet));
    assertFalse(aSet.equals(empty));
    assertFalse(aSet.equals(nullSet));
    assertFalse(aSet.equals(differentType));
    assertFalse(aSet.equals(differentItems));
  }

  @Test
  public void testHashCode() {
    empty = empty.add(1);
    empty = empty.add(2);
    empty = empty.add(3);
    empty = empty.add(4);
    empty = empty.add(5);
    empty = empty.add(6);
    empty = empty.remove(6);
    empty = empty.remove(5);
    assertTrue(aSet.hashCode() == empty.hashCode());
    assertTrue(aSet.hashCode() == sameSet.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Set = [1, 2, 3, 4], size = 4", aSet.toString());
    assertEquals("Set = [], size = 0", empty.toString());
  }
}