package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IndividualPersonTest {

  IndividualPerson test;

  @Before
  public void setUp() throws Exception {
    test = new IndividualPerson("A", "Test");
  }

  @Test
  public void testToString() {
    assertEquals("IndividualPerson{firstName='A', lastName='Test'}", test.toString());
  }
}