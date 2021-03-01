package problem2;

/**
 * Represents a Set of Integers
 */
public interface ISet {

  /**
   * Creates a new empty set
   * @return A new empty set
   */
  static ISet emptySet() {
    return new EmptySet();
  }

  /**
   * Checks if the set is empty
   * @return true if the set is empty, false otherwise
   */
  Boolean isEmpty();

  /**
   * Adds an integer to the set
   * @param n The integer to add
   * @return A new Set object with the added integer.
   */
  ISet add(Integer n);

  /**
   * Checks if the set contains a given integer
   * @param n The integer to check
   * @return true if the set contains a given integer, false otherwise
   */
  Boolean contains(Integer n);

  /**
   * Removes the given integer from the set
   * @param n The integer to remove
   * @return A new Set object without the removed integer
   */
  ISet remove(Integer n);

  /**
   * Returns the number of elements in the set
   * @return The number of elements.
   */
  Integer size();
}
