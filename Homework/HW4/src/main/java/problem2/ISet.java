package problem2;

public interface ISet {

  /**
   * Creates an empty set
   * @return An empty set
   */
  Set emptySet();

  /**
   * Checks if the set is empty
   * @return true if the set contains no items, false otherwise
   */
  Boolean isEmpty();

  /**
   * Adds the given integer to the set if and only if that integer is not already in the set.
   * @param n The integer to add
   * @return a copy of the set with the added integer.
   */
  Set add(Integer n);

  /**
   * Checks if the given integer is in the set.
   * @param n The integer to check
   * @return true if the given integer is in the set, false otherwise.
   */
  Boolean contains(Integer n);

  /**
   * Removes the given integer from the set.
   * set as is.
   * @param n The integer to remove
   * @return a copy of the set with the given integer removed. If the integer is not in
   * the set, returns the set as is.
   */
  Set remove(Integer n);

  /**
   * Gets the number of items in the set
   * @return The number of items in the set
   */
  Integer size();
}
