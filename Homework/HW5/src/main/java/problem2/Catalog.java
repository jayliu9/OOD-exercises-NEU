package problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a catalog used to store a collection of all the items in the library and
 * to implement search functionality.
 */
public class Catalog {

  private Set<Item> itemsInLibrary;

  /**
   * Constructor for the Catalog class. This constructor version creates a new Catalog object
   * without specifying the items in the collection
   */
  public Catalog() {
    itemsInLibrary = new HashSet<>();
  }

  /**
   * Constructor for the Catalog class. This constructor version creates a new Catalog object
   * with specifying the items in the collection
   * @param itemInLibrary The collection of all items in the library.
   */
  public Catalog(Set<Item> itemInLibrary) {
    this.itemsInLibrary = itemInLibrary;
  }

  /**
   * Adds an item to the collection.
   * @param item The item to add
   */
  public void add(Item item) {
    this.itemsInLibrary.add(item);
  }

  /**
   * Removes an item from the collection
   * @param item The item to remove
   * @throws InvalidRemovalException if the item to remove does not exist.
   */
  public void remove(Item item) throws InvalidRemovalException {
    if (!this.itemsInLibrary.remove(item)) {
      throw new InvalidRemovalException("The item to remove does not exist!");
    }
  }

  /**
   * Retrieves all the items in the library’s collection that have a title containing
   * the keyword. This search is case insensitive.
   * @param keyword The keyword
   * @return the subset of items in the library’s collection that have a title containing
   * the keyword. This search is case insensitive.
   */
  public Set<Item> search(String keyword) {
    Set<Item> subset = new HashSet<>();
    for (Item item : this.itemsInLibrary) {
      if (item.hasKeyword(keyword)) {
        subset.add(item);
      }
    }
    return subset;
  }

  /**
   * Retrieves all items in the catalog that have an exact match for the given author
   * @param author The author to search for
   * @return the subset of items in the library’s collection that have an exact match
   * for the given author.
   */
  public Set<Item> search(Author author) {
    Set<Item> subset = new HashSet<>();
    for (Item item : this.itemsInLibrary) {
      if (item.hasCreator(author)) {
        subset.add(item);
      }
    }
    return subset;
  }

  /**
   * Retrieves all items in the catalog that have an exact match for the given artist. The artist
   * may be the sole creator of the Music or one member of a Band
   * @param artist The artist to search for
   * @return the subset of items in the library’s collection that have an exact match
   * for the given artist.
   */
  public Set<Item> search(RecordingArtist artist) {
    Set<Item> subset = new HashSet<>();
    for (Item item : this.itemsInLibrary) {
      if (item.hasCreator(artist)) {
        subset.add(item);
      }
    }
    return subset;
  }

  /**
   * Gets the collection of all items in the library.
   * @return The collection of all items in the library.
   */
  public Set<Item> getItemsInLibrary() {
    return this.itemsInLibrary;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(this.itemsInLibrary, catalog.itemsInLibrary);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.itemsInLibrary);
  }

  /**
   * Creates a string representation of the Catalog.
   * @return a string representation of the Catalog.
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "itemsInLibrary=" + this.itemsInLibrary +
        '}';
  }
}
