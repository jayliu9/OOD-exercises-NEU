package problem2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Catalog {

  private List<Item> itemsInLibrary;

  public Catalog() {
    itemsInLibrary = new LinkedList<>();
  }

  public Catalog(List<Item> itemInLibrary) {
    this.itemsInLibrary = itemInLibrary;
  }

  public void add(Item item) {
    this.itemsInLibrary.add(item);
  }

  public void remove(Item item) throws InvalidItemRemovalException {
    if (!this.itemsInLibrary.remove(item)) {
      throw new InvalidItemRemovalException();
    }
  }

  public List<Item> search(String keyword) {
    List<Item> subList = new LinkedList<>();
    for (Item item : this.itemsInLibrary) {
      if (item.hasKeyword(keyword)) {
        subList.add(item);
      }
    }
    return subList;
  }

  public List<Item> search(Author author) {
    List<Item> subList = new LinkedList<>();
    for (Item item : this.itemsInLibrary) {
      if (item.hasCreator(author)) {
        subList.add(item);
      }
    }
    return subList;
  }

  public List<Item> search(RecordingArtist artist) {
    List<Item> subList = new LinkedList<>();
    for (Item item : this.itemsInLibrary) {
      if (item.hasCreator(artist)) {
        subList.add(item);
      }
    }
    return subList;
  }

  public List<Item> getItemsInLibrary() {
    return this.itemsInLibrary;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(this.itemsInLibrary);
  }

  @Override
  public String toString() {
    return "Catalog{" +
        "itemsInLibrary=" + this.itemsInLibrary +
        '}';
  }
}
