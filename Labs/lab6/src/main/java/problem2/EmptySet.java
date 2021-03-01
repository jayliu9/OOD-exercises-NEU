package problem2;

/**
 * Represents the empty set of integers.
 */
public class EmptySet implements ISet {

  /**
   * Checks if the set is empty
   * @return true if the set is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Adds an integer to the set
   * @param n The integer to add
   * @return A new Set object with the added integer.
   */
  @Override
  public ISet add(Integer n) {
    return new ConsSet(n, this);
  }

  /**
   * Checks if the set contains a given integer
   * @param n The integer to check
   * @return true if the set contains a given integer, false otherwise
   */
  @Override
  public Boolean contains(Integer n) {
    return false;
  }

  /**
   * Removes the given integer from the set
   * @param n The integer to remove
   * @return A new Set object without the removed integer
   */
  @Override
  public ISet remove(Integer n) {
    return this;
  }

  /**
   * Returns the number of elements in the set
   * @return The number of elements.
   */
  @Override
  public Integer size() {
    return 0;
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
   * Creates a string representation of the EmptySet.
   * @return a string representation of the EmptySet.
   */
  @Override
  public String toString() {
    return "EmptySet{}";
  }
}
