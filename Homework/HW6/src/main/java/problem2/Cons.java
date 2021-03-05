package problem2;

import java.util.Objects;

/**
 * Represents a non-empty multiset
 */
public class Cons implements IMultiset {

  private String item;
  private IMultiset rest;

  /**
   * Constructor for the Cons class. This creates a new multiset with the new item and the given
   * multiset.
   * @param item The new item
   * @param rest The given multiset to add the new item
   */
  public Cons(String item, IMultiset rest) {
    this.item = item;
    this.rest = rest;
  }

  /**
   * Gets the number of elements in the list.
   * @return The number of elements in the list.
   */
  @Override
  public Integer count() {
    return 1 + this.rest.count();
  }

  /**
   * Adds a new item to the multiset.
   * @param item The item to add
   * @return The new multiset with the new item added
   */
  @Override
  public IMultiset add(String item) {
    return new Cons(item, this);
  }

  /**
   * Removes a given item from the multiset.
   * @param item The item to remove
   * @return The new multiset without the removed item.
   */
  @Override
  public IMultiset remove(String item) {
    if (!this.contains(item)) {
      return this;
    }
    if (this.item.equals(item)) {
      return this.rest;
    }
    return new Cons(this.item, this.rest.remove(item));
  }

  /**
   * Checks if the multiset contains a given item
   * @param item The string to check
   * @return true if the multiset contains a given string, false otherwise
   */
  @Override
  public Boolean contains(String item) {
    if (this.item.equals(item)) {
      return true;
    }
    return this.rest.contains(item);
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
    Cons cons = (Cons) o;
    if (this.count() != cons.count()) {
      return false;
    }
    if (!this.contains(cons.item)) {
      return false;
    }
    return this.remove(cons.item).equals(cons.rest);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = 31 * this.count();
    result += 31 * Objects.hashCode(this.item);
    return result + this.rest.hashCode();
  }

  /**
   * Returns a string representation of the Cons.
   * @return a string representation of the Cons.
   */
  @Override
  public String toString() {
    return "Cons{" +
        "item='" + this.item + '\'' +
        ", rest=" + this.rest +
        '}';
  }
}
