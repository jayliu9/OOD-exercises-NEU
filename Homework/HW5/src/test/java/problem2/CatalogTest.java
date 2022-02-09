package problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class CatalogTest {

  Catalog aCatalog;
  Catalog empty;
  Music bandMusic;
  Book book;
  Music onePersonMusic;
  Author author;
  RecordingArtist first;
  RecordingArtist second;
  Catalog same;
  Catalog nullCatalog;


  @Before
  public void setUp() throws Exception {
    empty = new Catalog();

    author = new Author("Harry", "Potter");
    book = new Book(author, "Title", 1995);
    Set<RecordingArtist> members = new HashSet<>();
    first = new RecordingArtist("A", "B");
    second = new RecordingArtist("Harry", "Potter");
    members.add(first);
    members.add(second);
    Band band = new Band("Band", members);
    bandMusic = new Music(band, "Title", 1995);
    onePersonMusic = new Music(second, "Title", 1995);
    Set<Item> items = new HashSet<>();
    items.add(book);
    items.add(bandMusic);
    items.add(onePersonMusic);
    aCatalog = new Catalog(items);
    same = new Catalog(items);
    nullCatalog = null;
  }

  @Test
  public void add() {
    empty.add(book);

    Author testAuthor = new Author("Harry", "Potter");
    Book testBook = new Book(testAuthor, "Title", 1995);
    Set<Item> testSet = new HashSet<>();
    testSet.add(testBook);
    Catalog test = new Catalog(testSet);

    assertEquals(test, empty);
  }

  @Test
  public void remove() throws InvalidRemovalException {
    RecordingArtist testFirst = new RecordingArtist("Harry", "Potter");
    Music testOnePersonMusic = new Music(testFirst, "Title", 1995);
    Author testAuthor = new Author("Harry", "Potter");
    Book testBook = new Book(testAuthor, "Title", 1995);
    aCatalog.remove(testOnePersonMusic);
    aCatalog.remove(testBook);
    empty.add(bandMusic);
    assertEquals(empty, aCatalog);
  }

  @Test
  public void searchByAuthor() {
    Book secondBook = new Book(author, "Another", 1998);
    Book thirdBook = new Book(author, "Third", 2000);
    aCatalog.add(secondBook);
    aCatalog.add(thirdBook);
    Author authorToSearch = new Author("Harry", "Potter");
    Author noBook = new Author("No", "Book");

    Set<Item> emptySubset = new HashSet<>();
    Set<Item> subset = new HashSet<>();
    assertEquals(emptySubset, aCatalog.search(noBook));
    subset.add(thirdBook);
    subset.add(book);
    subset.add(secondBook);
    assertEquals(subset, aCatalog.search(authorToSearch));
    ;
  }

  @Test
  public void searchByKeyword() {
    Book secondBook = new Book(author, "Another", 1998);
    Book thirdBook = new Book(author, "Third", 2000);
    aCatalog.add(secondBook);
    aCatalog.add(thirdBook);
    Set<Item> subset = new HashSet<>();
    subset.add(onePersonMusic);
    subset.add(secondBook);
    subset.add(bandMusic);
    subset.add(book);
    Set<Item> emptySubset = new HashSet<>();

    assertEquals(subset, aCatalog.search("e"));
    assertEquals(subset, aCatalog.search("E"));
    assertEquals(emptySubset, aCatalog.search("abc"));
  }

  @Test
  public void searchByArtist() {
    RecordingArtist thirdArtist = new RecordingArtist("Third", "Artist");
    RecordingArtist fourthArtist = new RecordingArtist("Fourth", "Artist");
    RecordingArtist noSong = new RecordingArtist("No", "Song");
    Band secondBand = new Band("One Band");
    Band thirdBand = new Band("Another Band");
    secondBand.addMember(first);
    secondBand.addMember(second);
    secondBand.addMember(fourthArtist);
    thirdBand.addMember(fourthArtist);
    thirdBand.addMember(thirdArtist);
    Music newSong = new Music(secondBand, "New Song", 2001);
    Music anotherNewSong = new Music(thirdBand, "Another New Song", 2005);
    aCatalog.add(newSong);
    aCatalog.add(anotherNewSong);
    Set<Item> emptySubset = new HashSet<>();
    Set<Item> subset = new HashSet<>();
    subset.add(bandMusic);
    subset.add(onePersonMusic);
    subset.add(newSong);
    assertEquals(subset, aCatalog.search(second));
    assertEquals(emptySubset, aCatalog.search(noSong));
  }


  @Test
  public void getItemsInLibrary() {
    Set<Item> emptySet = new HashSet<>();
    assertEquals(emptySet, empty.getItemsInLibrary());
  }

  @Test
  public void testEquals() {
    assertTrue(aCatalog.equals(aCatalog));
    assertTrue(aCatalog.equals(same));
    assertFalse(aCatalog.equals(nullCatalog));
    assertFalse(aCatalog.equals(empty));
    assertFalse(aCatalog.equals(first));
  }

  @Test
  public void testHashCode() {
    assertTrue(aCatalog.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Catalog{itemsInLibrary=[Music{creator=Band{name='Band'"
        + ", members=[RecordingArtist{firstName='A', lastName='B'}"
        + ", RecordingArtist{firstName='Harry', lastName='Potter'}]}, title='Title', year=1995}"
        + ", Book{creator=Author{firstName='Harry', lastName='Potter'}, title='Title', year=1995}"
        + ", Music{creator=RecordingArtist{firstName='Harry', lastName='Potter'}"
        + ", title='Title', year=1995}]}", aCatalog.toString());
  }

  @Test(expected = InvalidRemovalException.class)
  public void invalidRemoval() throws InvalidRemovalException {
    empty.remove(bandMusic);
  }
}