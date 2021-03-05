package problem1;

/**
 * Represents an empty linked list of strings.
 */
public class EmptyNode implements ILinkedList {

  /**
   * Constructor for the EmptyNode class. This creates an empty linked list.
   */
  public EmptyNode() {
  }

  /**
   * Gets the number of elements in the list.
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Gets the item at the head of the list.
   * @return The String at the head of the list or null if the list is empty.
   */
  @Override
  public String getItem() {
    return null;
  }

  /**
   * Gets the rest of the list.
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedList getRest() {
    return null;
  }

  /**
   * Inserts a new item to the list in descending order of the priority. If multiple items in the
   * list have the same priority as the new item, the new item will be inserted into the last
   * position among those which have same priority.
   * @param item The new item to insert.
   * @param priority The priority of the new item
   * @return The linked list with the new item inserted.
   */
  @Override
  public ILinkedList insertAt(String item, Integer priority) {
    return new ElementNode(priority, item, this);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return 31;
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
   * Returns a string representation of the EmptyNode.
   * @return a string representation of the EmptyNode.
   */
  @Override
  public String toString() {
    return "EmptyNode";
  }
}
