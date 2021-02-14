package problem2;

/**
 * A List represents an ordered, mutable collection of Strings.
 */
public interface IListOfStrings {

  /**
   * Checks whether or not the list is empty
   * @return true if the list is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Gets the total number of elements in the list
   * @return The total number of elements in the list
   */
  int size();

  /**
   * Checks if the string is in the list or not
   * @param data The string to check
   * @return true if the string is in the list, false otherwise
   */
  boolean contains(String data);

  /**
   * Checks that all elements of this list are in the list passed as argument
   * @param list The list passed as argument
   * @return true if all elements of this list are in the list passed as argument, false otherwise
   */
  boolean containsAll(IListOfStrings list);

  /**
   * Returns a list with all elements whose length is greater than the maximum length removed.
   * @param maxLength The maximum string length
   * @return A list with all elements whose length is greater than the maximum length removed
   */
  IListOfStrings filterLargerThan(int maxLength);

  /**
   * Check if the list has at least one duplicate element.
   * @return true if the list has at least one duplicate element, false otherwise
   */
  boolean hasDuplicates();

  /**
   * Returns the list with all duplicates removed
   * @return The list with all duplicates removed
   */
  IListOfStrings removeDuplicates();

  /**
   * Creates an empty list.
   * @return An empty list.
   */
  void add(String data);
}
