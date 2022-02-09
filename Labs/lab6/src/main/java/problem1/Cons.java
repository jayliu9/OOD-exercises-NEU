package problem1;

/**
 * Represents a non-emty list of integers
 */
public class Cons implements List {

  private Integer first;
  private List rest;

  /**
   * Given an integer and a list create a new list with the same elements as {@code rest} and with
   * {@code first} prepended.
   *
   * @param first new element to add to the beginning of the list
   * @param rest  the list we are going to use to add our new element
   */
  public Cons(Integer first, List rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Getter for property 'first'.
   *
   * @return Value for property 'first'.
   */
  public Integer getFirst() {
    return this.first;
  }

  /**
   * Getter for property 'rest'.
   *
   * @return Value for property 'rest'.
   */
  public List getRest() {
    return this.rest;
  }

  /**
   * Returns the total number of elements in the list.
   *
   * @return number of elements in this list
   */
  @Override
  public Integer size() {
    return 1 + this.getRest().size();
  }

  /**
   * Checks if the list is empty
   *
   * @return true if empty and false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return false;
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
   */
  @Override
  public Integer last() {
    if (this.rest.isEmpty()) {
      return this.first;
    } else {
      return this.rest.last();
    }
  }

  /**
   * Checks if the list contains the given element.
   *
   * @param element The element to check
   * @return true if the element is in the list, false otherwise
   */
  @Override
  public Boolean contain(Integer element) {
    if (this.first.equals(element)) {
      return true;
    }
    return this.rest.contain(element);
  }

  /**
   * Returns the element found at index in the list
   *
   * @param index The given index
   * @return The element found at index in the list
   * @throws InvalidCallException if the index is out of bound.
   */
  @Override
  public Integer elementAt(Integer index) throws InvalidCallException {
    this.checkIndex(index);
    if (index == 0) {
      return this.first;
    }
    return this.rest.elementAt(index - 1);
  }

  /**
   * Chceks that the index is inside of bound.
   * @param index The index to check
   * @throws InvalidCallException if the index is out of bound.
   */
  private void checkIndex(Integer index) throws InvalidCallException {
    if (index >= this.size() || index < 0) {
      throw new InvalidCallException("The index is out of bound!");
    }
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
    }

    Cons cons = (Cons) o;

    if (getFirst() != null ? !getFirst().equals(cons.getFirst()) : cons.getFirst() != null) {
      return false;
    }
    return getRest() != null ? getRest().equals(cons.getRest()) : cons.getRest() == null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    int result = getFirst() != null ? getFirst().hashCode() : 0;
    result = 31 * result + (getRest() != null ? getRest().hashCode() : 0);
    return result;
  }

  /**
   * Creates a string representation of the Cons.
   * @return a string representation of the Cons.
   */
  @Override
  public String toString() {
    return "Cons{"
        + "first=" + first
        + ", rest=" + rest
        + '}';
  }


}
