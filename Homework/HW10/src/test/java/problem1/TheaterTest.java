package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TheaterTest {

  Theater t;
  Theater same;
  Theater nullType;
  String diffType;
  Theater diffName;
  Theater diffRows;
  Theater diffSeatsInRow;
  Theater diffRowsForWheelchair;

  @Before
  public void setUp() throws Exception {
    List<Integer> rowsForWheelchair = new ArrayList<>();
    rowsForWheelchair.add(10);
    t = new Theater("A", 15, 10, rowsForWheelchair);

    same = new Theater("A", 15, 10, rowsForWheelchair);
    nullType = null;
    diffType = "Theater";
    diffName = new Theater("B", 15, 10, rowsForWheelchair);
    diffRows = new Theater("A", 20, 10, rowsForWheelchair);
    diffSeatsInRow = new Theater("A", 15, 15, rowsForWheelchair);

    List<Integer> newRowsForWheelchair = new ArrayList<>();
    newRowsForWheelchair.add(8);
    newRowsForWheelchair.add(12);
    diffRowsForWheelchair = new Theater("A", 15, 10, newRowsForWheelchair);
  }

  @Test
  public void testEquals() {
    assertTrue(t.equals(t));
    assertTrue(t.equals(same));
    assertFalse(t.equals(nullType));
    assertFalse(t.equals(diffName));
    assertFalse(t.equals(diffRows));
    assertFalse(t.equals(diffType));
    assertFalse(t.equals(diffRowsForWheelchair));
    assertFalse(t.equals(diffSeatsInRow));
  }

  @Test
  public void testHashCode() {
    assertTrue(t.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Theater{name='A', numOfRows=15, numOfSeatsInRow=10, linesWheelchairAccessible=[10]}", t.toString());
  }

  @Test(expected = NoAccessibleRowException.class)
  public void noAccessibleRows() throws NoAccessibleRowException {
    List<Integer> noRowsForWheelchair = new ArrayList<>();
    Theater invalid = new Theater("A", 15, 10, noRowsForWheelchair);
  }
}