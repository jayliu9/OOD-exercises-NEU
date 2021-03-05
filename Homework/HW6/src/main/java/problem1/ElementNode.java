package problem1;

import java.util.Objects;

/**
 * Represents a non-empty linked list of String.
 */
public class ElementNode implements ILinkedList {

  private Integer priority;
  private String item;
  private ILinkedList rest;

  /**
   * Creates a new ElementNode object with the a new item, its priority and a given linked list
   * @param priority The priority of the element
   * @param item The new item
   * @param rest The given linked list.
   */
  public ElementNode(Integer priority, String item, ILinkedList rest) {
    this.priority = priority;
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
   * Gets the item at the head of the list.
   * @return The String at the head of the list or null if the list is empty.
   */
  @Override
  public String getItem() {
    return this.item;
  }

  /**
   * Gets the rest of the list.
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedList getRest() {
    return this.rest;
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
    if (priority > this.priority) {
      return new ElementNode(priority, item, this);
    } else {
      return new ElementNode(this.priority, this.item, this.rest.insertAt(item, priority));
    }
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
    ElementNode that = (ElementNode) o;
    return Objects.equals(this.priority, that.priority) && Objects
        .equals(this.item, that.item) && Objects.equals(this.rest, that.rest);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.priority, this.item, this.rest);
  }

  /**
   * Creates a string representation of the ElementNode.
   * @return a string representation of the ElementNode.
   */
  @Override
  public String toString() {
    return "ElementNode{" +
        "priority=" + priority +
        ", item='" + item + '\'' +
        ", rest=" + rest +
        '}';
  }
}
