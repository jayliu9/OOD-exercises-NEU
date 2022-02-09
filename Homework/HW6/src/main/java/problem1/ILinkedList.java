package problem1;

/**
 * Required operations for a linked list of strings
 */
public interface ILinkedList {

  /**
   * Gets the number of elements in the list.
   * @return THe number of elements in the list.
   */
  Integer count();

  /**
   * Gets the item at the head of the list.
   * @return The String at the head of the list or null if the list is empty.
   */
  String getItem();

  /**
   * Gets the rest of the list.
   * @return The rest of the list or null if the list is empty.
   */
  ILinkedList getRest();

  /**
   * Inserts a new item to the list in descending order of the priority. If multiple items in the
   * list have the same priority as the new item, the new item will be inserted into the last
   * position among those which have same priority.
   * @param item  The new item to insert.
   * @param priority The priority of the new item
   * @return The linked list with the new item inserted.
   */
  ILinkedList insertAt(String item, Integer priority);
}
