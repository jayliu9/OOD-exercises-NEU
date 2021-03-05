package problem2;

/**
 * Represents a empty multiset of strings.
 */
public class Empty implements IMultiset {

  /**
   * Constructor for the Empty class. This creates an empty multiset.
   */
  public Empty() {
  }

  /**
   * Gets the number of elements in the list.
   * @return The number of elements in the list.
   */
  @Override
  public Integer count() {
    return 0;
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
    return this;
  }

  /**
   * Checks if the multiset contains a given item
   * @param item The string to check
   * @return true if the multiset contains a given string, false otherwise
   */
  @Override
  public Boolean contains(String item) {
    return false;
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return 42;
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
    return true;
  }

  /**
   * Returns a string representation of the Empty.
   * @return a string representation of the Empty.
   */
  @Override
  public String toString() {
    return "Empty{}";
  }
}
