package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {

  Course math;
  Course nullCourse;
  String differentType;
  Course differentName;
  Course differentPrefix;

  @Before
  public void setUp() throws Exception {
    math = new Course("Math", "A", 5);
    nullCourse = null;
    differentType = "Math";
    differentName = new Course("Test", "A", 5);
    differentPrefix = new Course("Math", "T", 5);
  }

  @Test
  public void testEquals() {
    assertFalse(math.equals(nullCourse));
    assertFalse(math.equals(differentType));
    assertFalse(math.equals(differentName));
    assertFalse(math.equals(differentPrefix));
  }
}