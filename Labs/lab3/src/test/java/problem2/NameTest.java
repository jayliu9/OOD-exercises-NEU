package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  Name name;
  Name equalName;
  String differentClass;
  Name nullName;
  Name differentFirstName;
  Name differentLastName;

  @Before
  public void setUp() throws Exception {
    name = new Name("Harry", "Potter");
    equalName = new Name("Harry", "Potter");
    nullName = null;
    differentFirstName = new Name("A", "Potter");
    differentClass = "Harry Potter";
    differentLastName = new Name("Harry", "B");
  }

  @Test
  public void getFirstName() {
    assertEquals("Harry", name.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Potter", name.getLastName());
  }

  @Test
  public void testEquals() {
    assertTrue(name.equals(equalName));
    assertTrue(name.equals(name));
    assertFalse(name.equals(differentClass));
    assertFalse(name.equals(nullName));
    assertFalse(name.equals(differentFirstName));
    assertFalse(name.equals(differentLastName));
  }

  @Test
  public void testHashCode() {
    assertTrue(name.hashCode() == equalName.hashCode());
  }
}