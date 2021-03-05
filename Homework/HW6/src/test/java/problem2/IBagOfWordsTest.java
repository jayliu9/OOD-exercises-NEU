package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IBagOfWordsTest {
  IBagOfWords aBag;
  IBagOfWords empty;
  IBagOfWords same;
  IBagOfWords nullType;
  IBagOfWords diffWords;
  String diffType;
  IBagOfWords diffOrder;

  @Before
  public void setUp() throws Exception {
    aBag = IBagOfWords.emptyBagOfWords();
    aBag = aBag.add("dog");
    aBag = aBag.add("cat");
    aBag = aBag.add("dog");
    empty = IBagOfWords.emptyBagOfWords();
    IBagOfWords shared = IBagOfWords.emptyBagOfWords();
    shared = shared.add("dog");
    shared = shared.add("cat");
    same = shared.add("dog");
    nullType = null;
    diffWords = shared.add("bird");
    diffType = "aBag";
    diffOrder = IBagOfWords.emptyBagOfWords();
    diffOrder = diffOrder.add("cat");
    diffOrder = diffOrder.add("dog");
    diffOrder = diffOrder.add("dog");
  }

  @Test
  public void isEmpty() {
    assertTrue(empty.isEmpty());
    assertFalse(aBag.isEmpty());
  }

  @Test
  public void size() {
    assertEquals(Integer.valueOf(0), empty.size());
    assertEquals(Integer.valueOf(3), aBag.size());
  }

  @Test
  public void add() {
    IBagOfWords addOne = empty.add("lion");
    IBagOfWords test = IBagOfWords.emptyBagOfWords();
    test = test.add("lion");
    assertEquals(test, addOne);
  }

  @Test
  public void contains() {
    assertTrue(aBag.contains("cat"));
    assertFalse(aBag.contains("bird"));
  }

  @Test
  public void testEquals() {
    assertTrue(aBag.equals(aBag));
    assertTrue(aBag.equals(same));
    assertTrue(aBag.equals(diffOrder));
    assertFalse(aBag.equals(diffWords));
    assertFalse(aBag.equals(diffType));
    assertFalse(aBag.equals(nullType));
  }

  @Test
  public void testHashCode() {
    assertTrue(aBag.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("BagOfWords{words=Cons{item='dog', rest="
        + "Cons{item='cat', rest="
        + "Cons{item='dog', rest=Empty{}}}}}", aBag.toString());
  }
}