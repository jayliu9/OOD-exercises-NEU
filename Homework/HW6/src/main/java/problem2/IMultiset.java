package problem2;

/**
 * Required operations for a multiset of strings
 */
public interface IMultiset {

  /**
   * Gets the number of elements in the list.
   * @return The number of elements in the list.
   */
  Integer count();

  /**
   * Adds a new item to the multiset.
   * @param item The item to add
   * @return The new multiset with the new item added
   */
  IMultiset add(String item);

  /**
   * Removes a given item from the multiset.
   * @param item The item to remove
   * @return The new multiset without the removed item.
   */
  IMultiset remove(String item);

  /**
   * Checks if the multiset contains a given item
   * @param item The string to check
   * @return true if the multiset contains a given string, false otherwise
   */
  Boolean contains(String item);
}
