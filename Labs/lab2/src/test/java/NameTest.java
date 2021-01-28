import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
  Name name;

  @Before
  public void setUp() throws Exception {
    name = new Name("Hello", "World");
  }

  @Test
  public void setFirstName() {
    name.setFirstName("Hi");
    assertEquals("Hi", name.getFirstName());
  }


  @Test
  public void setLastName() {
    name.setLastName("Goodbye");
    assertEquals("Goodbye", name.getLastName());
  }
}