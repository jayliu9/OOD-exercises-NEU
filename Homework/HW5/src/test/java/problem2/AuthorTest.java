package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AuthorTest {

  Author author;
  Author same;
  Author nullAuthor;
  RecordingArtist differentType;
  Author differentFirstName;
  Author differentLastName;

  @Before
  public void setUp() throws Exception {
    author = new Author("Harry", "Potter");
    same = new Author("Harry", "Potter");
    nullAuthor = null;
    differentType = new RecordingArtist("A", "B");
    differentFirstName = new Author("A", "Potter");
    differentLastName = new Author("Harry", "B");
  }

  @Test
  public void getFirstName() {
    assertEquals("Harry", author.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Potter", author.getLastName());
  }

  @Test
  public void testIsExactMatch() {
    Author match = new Author("Harry", "Potter");
    RecordingArtist noMatch = new RecordingArtist("Harry", "Potter");
    assertTrue(author.isExactMatch(match));
    assertFalse(author.isExactMatch(noMatch));
  }

  @Test
  public void testEquals() {
    assertTrue(author.equals(same));
    assertTrue(author.equals(author));
    assertFalse(author.equals(nullAuthor));
    assertFalse(author.equals(differentType));
    assertFalse(author.equals(differentFirstName));
    assertFalse(author.equals(differentLastName));
  }

  @Test
  public void testHashCode() {
    assertTrue(author.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Author{firstName='Harry', lastName='Potter'}", author.toString());
  }
}