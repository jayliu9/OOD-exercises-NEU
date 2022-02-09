package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

  Author author;
  Book book;
  Book same;
  Music differentType;
  Book nullBook;
  Book differentAuthor;
  Book differentTitle;
  Book differentYear;

  @Before
  public void setUp() throws Exception {
    author = new Author("Harry", "Potter");
    Author another = new Author("Another", "Author");
    RecordingArtist artist = new RecordingArtist("An", "Artist");
    book = new Book(author, "Title", 1995);
    same = new Book(author, "Title", 1995);
    differentType = new Music(artist, "Title", 1995);
    nullBook = null;
    differentAuthor = new Book(another, "Title", 1995);
    differentTitle = new Book(author, "Other", 1995);
    differentYear = new Book(author, "Title", 2000);
  }

  @Test
  public void getCreator() {
    Author test = new Author("Harry", "Potter");
    assertEquals(test, book.getCreator());
  }

  @Test
  public void getYear() {
    assertEquals(1995, book.getYear());
  }

  @Test
  public void getTitle() {
    assertEquals("Title", book.getTitle());
  }

  @Test
  public void testHasKeyword() {
    assertTrue(book.hasKeyword("Title"));
    assertTrue(book.hasKeyword("it"));
    assertTrue(book.hasKeyword("ITL"));
    assertTrue(book.hasKeyword("lE"));
    assertFalse(book.hasKeyword("abc"));
    assertFalse(book.hasKeyword("lea"));
    assertTrue(book.hasKeyword(""));
    assertFalse(book.hasKeyword(" "));
  }

  @Test
  public void testHasCreator() {
    Author anAuthor = new Author("Harry", "Potter");
    RecordingArtist anArtist = new RecordingArtist("Harry", "Potter");
    assertTrue(book.hasCreator(anAuthor));
    assertFalse(book.hasCreator(anArtist));
  }

  @Test
  public void testEquals() {
    assertTrue(book.equals(book));
    assertTrue(book.equals(same));
    assertFalse(book.equals(nullBook));
    assertFalse(book.equals(differentType));
    assertFalse(book.equals(differentAuthor));
    assertFalse(book.equals(differentTitle));
    assertFalse(book.equals(differentYear));
  }

  @Test
  public void testHashCode() {
    assertTrue(book.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Book{creator=Author{firstName='Harry', lastName='Potter'}"
        + ", title='Title', year=1995}", this.book.toString());
  }
}