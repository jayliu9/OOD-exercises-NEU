package problem1;

/**
 * Represents a List of Integers
 */
public interface List {

  /**
   * Creates a new empty list
   * @return a new empty list.
   */
  static List createList() {
    return new Empty();
  }

  /**
   * Returns the total number of elements in the list.
   *
   * @return number of elements in this list
   */
  Integer size();


  /**
   * Checks if the list is empty
   *
   * @return true if empty and false otherwise
   */
  Boolean isEmpty();

  /**
   * Given a new element {@code element} prepend it to this list
   *
   * @param element new element to add to the list
   * @return updated list with {@code element} prependeds
   */
  List add(Integer element);


  /**
   * Return the last element of this list.
   *
   * @return the last element of this list.
   */
  Integer last();

  /**
   * Checks if the list contains the given element.
   *
   * @param element The element to check
   * @return true if the element is in the list, false otherwise
   */
  Boolean contain(Integer element);

  /**
   * Returns the element found at index in the list
   *
   * @param index The given index
   * @return The element found at index in the list
   */
  Integer elementAt(Integer index);
}
