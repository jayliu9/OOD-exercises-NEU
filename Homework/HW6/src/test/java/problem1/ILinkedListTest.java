package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ILinkedListTest {

  ILinkedList aList;
  ILinkedList empty;
  ILinkedList same;
  String diffType;
  ILinkedList diffItem;
  ILinkedList diffRest;
  ILinkedList nullList;
  ILinkedList diffPriority;

  @Before
  public void setUp() throws Exception {
    aList = new EmptyNode();
    aList = aList.insertAt("A", 10);
    aList = aList.insertAt("B", 8);
    aList = aList.insertAt("Z", -5);
    aList = aList.insertAt("L", 8);
    empty = new EmptyNode();
    same = new EmptyNode();
    same = same.insertAt("A", 10);
    same = same.insertAt("B", 8);
    same = same.insertAt("Z", -5);
    same = same.insertAt("L", 8);
    diffType = "aList";
    diffItem = new EmptyNode();
    diffItem = diffItem.insertAt("X", 10);
    diffItem = diffItem.insertAt("B", 8);
    diffItem = diffItem.insertAt("Z", -5);
    diffItem = diffItem.insertAt("L", 8);
    diffRest = aList.insertAt("O", 4);
    nullList = null;
    diffPriority = new EmptyNode();
    diffPriority = diffPriority.insertAt("A", 15);
    diffPriority = diffPriority.insertAt("B", 8);
    diffPriority = diffPriority.insertAt("Z", -5);
    diffPriority = diffPriority.insertAt("L", 8);
  }

  @Test
  public void count() {
    assertEquals(Integer.valueOf(0), empty.count());
    assertEquals(Integer.valueOf(4), aList.count());
  }

  @Test
  public void getItem() {
    assertEquals("A", aList.getItem());
    assertEquals(null, empty.getItem());
  }

  @Test
  public void getRest() {
    ILinkedList rest = new EmptyNode();
    rest = rest.insertAt("B", 8);
    rest = rest.insertAt("Z", -5);
    rest = rest.insertAt("L", 8);
    assertEquals(rest, aList.getRest());
    assertEquals(null, empty.getRest());
  }

  @Test
  public void insertAt() {
    ILinkedList testList = empty.insertAt("A", 10);
    testList = testList.insertAt("B", 8);
    testList = testList.insertAt("Z", -5);
    testList = testList.insertAt("L", 8);
    assertEquals(testList, aList);
  }

  @Test
  public void testEquals() {
    assertTrue(aList.equals(same));
    assertTrue(aList.equals(aList));
    assertFalse(aList.equals(diffType));
    assertFalse(aList.equals(diffItem));
    assertFalse(aList.equals(diffRest));
    assertFalse(aList.equals(nullList));
    assertFalse(aList.equals(diffPriority));
  }

  @Test
  public void testHashCode() {
    assertTrue(aList.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ElementNode{priority=10, item='A', rest="
        + "ElementNode{priority=8, item='B', rest="
        + "ElementNode{priority=8, item='L', rest="
        + "ElementNode{priority=-5, item='Z', rest=EmptyNode}}}}", aList.toString());
  }
}