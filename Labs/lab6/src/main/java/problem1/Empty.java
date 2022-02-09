package problem1;

/**
 * Represents the empty list of integers.
 */


public class Empty implements List {

  /**
   * Returns the total number of elements in the list.
   *
   * @return number of elements in this list
   */
  @Override
  public Integer size() {
    return 0;
  }

  /**
   * Checks if the list is empty
   *
   * @return true if empty and false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return true;
  }

  /**
   * Given a new element {@code element} prepend it to this list
   *
   * @param element new element to add to the list
   * @return updated list with {@code element} prependeds
   */
  @Override
  public List add(Integer element) {
    return new Cons(element, this);
  }

  /**
   * Return the last element of this list.
   *
   * @return the last element of this list.
   * @throws InvalidCallException if last() is called on this Empty class.
   */
  @Override
  public Integer last() throws InvalidCallException {
    throw new InvalidCallException("Called last() on empty!");
  }

  /**
   * Checks if the list contains the given element.
   *
   * @param element The element to check
   * @return true if the element is in the list, false otherwise
   */
  @Override
  public Boolean contain(Integer element) {
    return false;
  }

  /**
   * Returns the element found at index in the list
   *
   * @param index The given index
   * @return The element found at index in the list
   * @throws InvalidCallException if elementAt() is called on this Empty class.
   */
  @Override
  public Integer elementAt(Integer index) throws InvalidCallException {
    throw new InvalidCallException("Called elementAt() on empty!");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return 42;
  }

  /**
   * Creates a string representation of the Empty.
   *
   * @return a string representation of the Empty.
   */
  @Override
  public String toString() {
    return "Empty{}";
  }
}
