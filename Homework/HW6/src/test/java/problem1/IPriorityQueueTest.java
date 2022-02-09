package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IPriorityQueueTest {
  IPriorityQueue aQueue;
  IPriorityQueue empty;
  IPriorityQueue same;
  String diffType;
  IPriorityQueue nullQueue;
  IPriorityQueue diffFront;

  @Before
  public void setUp() throws Exception {
    aQueue = IPriorityQueue.createEmpty();
    aQueue = aQueue.add(10, "A");
    aQueue = aQueue.add(8, "B");
    aQueue = aQueue.add(-5, "Z");
    aQueue = aQueue.add(8, "L");
    empty = IPriorityQueue.createEmpty();
    same = IPriorityQueue.createEmpty();
    same = same.add(10, "A");
    same = same.add(8, "B");
    same = same.add(-5, "Z");
    same = same.add(8, "L");
    diffType = "aQueue";
    nullQueue = null;
    diffFront = aQueue.add(20, "K");
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(aQueue.isEmpty());
  }

  @Test
  public void peek() throws EmptyPriorityQueueException {
    assertEquals("A", aQueue.peek());
  }

  @Test
  public void peekSamePriority() throws EmptyPriorityQueueException {
    IPriorityQueue samePriority = aQueue.add(10, "R");
    assertEquals("A", samePriority.peek());
  }

  @Test(expected = EmptyPriorityQueueException.class)
  public void peekEmpty() throws EmptyPriorityQueueException {
    String test = empty.peek();
  }

  @Test
  public void pop() throws EmptyPriorityQueueException {
    IPriorityQueue testPop = IPriorityQueue.createEmpty();
    testPop = testPop.add(8, "B");
    testPop = testPop.add(-5, "Z");
    testPop = testPop.add(8, "L");
    assertEquals(testPop, aQueue.pop());
  }

  @Test
  public void popSamePriority() throws EmptyPriorityQueueException {
    IPriorityQueue one = empty.add(25, "U");
    one = one.add(25, "UU");
    one = one.add(24, "Last");
    IPriorityQueue testPopTwo = empty.add(24, "Last");
    IPriorityQueue testPopOne = testPopTwo.add(25, "UU");
    assertEquals(testPopOne, one.pop());
    assertEquals(testPopTwo, one.pop().pop());
  }

  @Test(expected = EmptyPriorityQueueException.class)
  public void popEmpty() throws EmptyPriorityQueueException {
    IPriorityQueue test = empty.pop();
  }

  @Test
  public void testEquals() {
    assertTrue(aQueue.equals(same));
    assertTrue(aQueue.equals(aQueue));
    assertFalse(aQueue.equals(diffFront));
    assertFalse(aQueue.equals(diffType));
    assertFalse(aQueue.equals(nullQueue));
  }

  @Test
  public void testHashCode() {
    assertTrue(aQueue.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("PriorityQueue{front=ElementNode{priority=10, item='A'"
        + ", rest=ElementNode{priority=8, item='B'"
        + ", rest=ElementNode{priority=8, item='L'"
        + ", rest=ElementNode{priority=-5, item='Z', rest=EmptyNode}}}}}", aQueue.toString());
  }
}