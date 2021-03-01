package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListTest {
  List aList;
  List same;
  List nullList;
  String differentType;
  List differentFirst;
  List differentRest;


  @Before
  public void setUp() throws Exception {
    aList = List.createList();
    aList = aList.add(1);
    same = List.createList();
    same = same.add(1);
    nullList = null;
    differentType = "List";
    differentFirst = List.createList();
    differentFirst = differentFirst.add(10);
    differentRest = List.createList();
    differentRest = differentRest.add(2);
    differentRest = differentRest.add(1);
  }

  @Test
  public void size() {
    assertEquals(Integer.valueOf(1), aList.size());
  }

  @Test
  public void isEmpty() {
    assertFalse(aList.isEmpty());
  }

  @Test
  public void add() throws InvalidCallException {
    aList = aList.add(2);
    List test = List.createList();
    test = test.add(1);
    test = test.add(2);
    assertEquals(test, aList);
  }

  @Test
  public void last() {
    assertEquals(Integer.valueOf(1), aList.last());
    aList = aList.add(2);
    assertEquals(Integer.valueOf(1), aList.last());
  }

  @Test
  public void contain() {
    assertTrue(aList.contain(1));
    assertFalse(aList.contain(2));
  }

  @Test
  public void elementAt() {
    assertEquals(Integer.valueOf(1), aList.elementAt(0));
    aList = aList.add(2);
    assertEquals(Integer.valueOf(1), aList.elementAt(1));
  }

  @Test (expected = InvalidCallException.class)
  public void tooLargeIndex() throws InvalidCallException {
    aList.elementAt(5);
  }

  @Test (expected = InvalidCallException.class)
  public void negativeIndex() throws InvalidCallException {
    aList.elementAt(-1);
  }

  @Test
  public void testEquals() {
    assertTrue(aList.equals(aList));
    assertTrue(aList.equals(same));
    assertFalse(aList.equals(nullList));
    assertFalse(aList.equals(differentFirst));
    assertFalse(aList.equals(differentRest));
    assertFalse(aList.equals(differentType));
    List testList = aList.add(2);
    assertFalse(testList.equals(differentRest));
    aList = aList.add(null);
    assertFalse(aList.equals(same));
    List testSame = same.add(null);
    assertTrue(aList.equals(testSame));
    List testCon = new Cons(2, null);
    assertFalse(testCon.equals(testList));
    List sameCon = new Cons(2, null);
    assertTrue(testCon.equals(sameCon));
  }

  @Test
  public void testHashCode() {
    assertTrue(aList.hashCode() == same.hashCode());
    List testCon = new Cons(1, null);
    assertFalse(aList.hashCode() == testCon.hashCode());
    aList = aList.add(null);
    assertFalse(aList.hashCode() == testCon.hashCode());

  }

  @Test
  public void testToString() {
    assertEquals("Cons{first=1, rest=Empty{}}", aList.toString());
  }
}