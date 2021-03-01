package problem2;

import java.util.Objects;

/**
 * Represents the non-empty set of integers.
 */
public class ConsSet implements ISet {

  private Integer first;
  private ISet rest;

  /**
   * Given an integer and a set create a new set with the same elements as {@code rest} and with
   * {@code first} prepended.
   * @param first new element to add to the beginning of the set
   * @param rest  the list we are going to use to add our new element
   */
  public ConsSet(Integer first, ISet rest) {
    this.first = first;
    this.rest = rest;
  }

  /**
   * Checks if the set is empty
   * @return true if the set is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return false;
  }

  /**
   * Adds an integer to the set
   * @param n The integer to add
   * @return A new Set object with the added integer.
   */
  @Override
  public ISet add(Integer n) {
    if (this.contains(n)) {
      return this;
    }
    return new ConsSet(n, this);
  }

  /**
   * Checks if the set contains a given integer
   * @param n The integer to check
   * @return true if the set contains a given integer, false otherwise
   */
  @Override
  public Boolean contains(Integer n) {
    if (this.first == n) {
      return true;
    }
    return this.rest.contains(n);
  }

  /**
   * Removes the given integer from the set
   * @param n The integer to remove
   * @return A new Set object without the removed integer
   */
  @Override
  public ISet remove(Integer n) {
    if (!this.contains(n)) {
      return this;
    }
    if (this.first == n) {
      return this.rest;
    }
    return new ConsSet(this.first, this.rest.remove(n));
  }

  /**
   * Returns the number of elements in the set
   * @return The number of elements.
   */
  @Override
  public Integer size() {
    return 1 + this.rest.size();
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
    ConsSet consSet = (ConsSet) o;
    if (this.size() != consSet.size()) {
      return false;
    }
    if (!this.contains(consSet.first)) {
      return false;
    }
    return this.remove(consSet.first).equals(consSet.rest);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = 31 * this.size();
    result += 31 * Objects.hashCode(this.first);
    return result + this.rest.hashCode();
  }

  /**
   * Creates a string representation of the ConsSet.
   * @return a string representation of the ConsSet.
   */
  @Override
  public String toString() {
    return "ConsSet{" +
        "first=" + this.first +
        ", rest=" + this.rest +
        '}';
  }
}
