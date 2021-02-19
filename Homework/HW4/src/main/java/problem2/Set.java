package problem2;

import java.util.Objects;

/**
 * Represents a Set, which is implemented using the array as the underlying data structure.
 */
public class Set implements ISet {

  private int size;
  private Integer[] items;
  private static final int DEFAULT_NUM_OF_SLOTS = 5;
  private static final int NOT_FOUND = -1;

  /**
   * Constructor for the Set class
   */
  public Set() {
    this.size = 0;
    this.items = new Integer[DEFAULT_NUM_OF_SLOTS];
  }

  /**
   * Private constructor that allows us to return a new copy from the producers.
   * @param size  The size of the set
   * @param items The items in the set
   */
  private Set(int size, Integer[] items) {
    this.size = size;
    this.items = items;
  }

  /**
   * Creates an empty set
   * @return An empty set
   */
  public static Set emptySet() {
    return new Set();
  }

  /**
   * Checks if the set is empty
   * @return true if the set contains no items, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Adds the given integer to the set if and only if that integer is not already in the set.
   * @param n The integer to add
   * @return a copy of the set with the added integer.
   */
  @Override
  public Set add(Integer n) {
    if (this.contains(n)) {
      return new Set(this.size, this.items.clone());
    }
    Integer[] newItems = this.overLength() ? this.resize() : this.items.clone();
    newItems[this.size] = n;
    return new Set(this.size + 1, newItems);
  }

  /**
   * Creating a new items array with increased length and the same items.
   *
   * @return a new items array with increased length and the same items.
   */

  private Integer[] resize() {
    int newSize = this.items.length + DEFAULT_NUM_OF_SLOTS;
    Integer[] newItems = new Integer[newSize];
    this.copyArray(this.items, newItems);
    return newItems;
  }

  /**
   * Helper function that copies the whole of the "from" array to the "to" array.
   * @param from The array to copy from
   * @param to The array to copy to
   */
  private void copyArray(Integer[] from, Integer[] to) {
    copyArray(from, to, 0, this.size, 0);
  }

  /**
   * Helper function that copies items "from" array to the "to" array.
   * @param from The array to copy from.
   * @param to The array to copy to.
   * @param fromStart The index in the "from" array to start copying from.
   * @param fromEnd The index in the "from" array to end at (exclusive).
   * @param toStart The index in the "to" array to start copying to.
   */
  private void copyArray(Integer[] from, Integer[] to, int fromStart, int fromEnd, int toStart) {
    for (int i = fromStart; i < fromEnd; i++) {
      to[toStart] = from[i];
      toStart++;
    }
  }

  /**
   * Helper function that checks if there is no room in the data array to add a new item.
   * @return true if there is no room to add a new item, false otherwise
   */
  private boolean overLength() {
    return this.size + 1 > this.items.length;
  }

  /**
   * Checks if the given integer is in the set.
   * @param n The integer to check
   * @return true if the given integer is in the set, false otherwise.
   */
  @Override
  public Boolean contains(Integer n) {
    if (this.findItem(n) == NOT_FOUND) {
      return false;
    }
    return true;
  }

  /**
   * Helper method that returns the index of an item, if found.
   * @param n The integer to find.
   * @return The item's index, if it is in the list, or -1.
   */
  private int findItem(Integer n) {
    for (int i = 0; i < this.size; i++) {
      if (this.items[i].equals(n)) {
        return i;
      }
    }
    return NOT_FOUND;
  }

  /**
   * Removes the given integer from the set.
   * @param n The integer to remove
   * @return A copy of the set with the given integer removed. If the integer is not in the set,
   * returns the set as is.
   */
  @Override
  public Set remove(Integer n) {
    int foundIndex = this.findItem(n);
    if (foundIndex == NOT_FOUND) {
      return new Set(this.size, this.items.clone());
    }
    Integer[] newItems = new Integer[this.items.length - 1];
    copyArray(this.items, newItems, 0, foundIndex, 0);
    copyArray(this.items, newItems, foundIndex + 1, this.size, foundIndex);
    return new Set(this.size - 1, newItems);
  }

  /**
   * Gets the number of items in the set
   * @return The number of items in the set
   */
  @Override
  public Integer size() {
    return this.size;
  }

  /**
   * Helper function that checks if this array have the same courses as the given array
   * of courses. Null items are excluded.
   * @param that The array of courses to compared to
   * @return true if both arrays contain the same courses in the same order, false otherwise.
   */
  private boolean sameItems(Integer[] that) {
    for(int i = 0; i < this.size; i++) {
      if(!this.contains(that[i])) {
        return false;
      }
    }
    return true;
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
    Set set = (Set) o;
    return this.size == set.size && this.sameItems(set.items);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result;
    for (int i = 0; i < this.size; i++) {
      result += 31 * Objects.hash(this.items[i]);
    }
    return result;
  }

  /**
   * Creates a string representation of the Set
   * @return a string representation of the Set.
   */
  @Override
  public String toString() {
    String stringOfSet = "";
    for (int i = 0; i < this.size; i++) {
      stringOfSet += this.items[i] + ", ";
    }
    if (!this.isEmpty()) {
      stringOfSet = stringOfSet.substring(0, stringOfSet.length() - ", ".length());
    }
    return "Set = [" + stringOfSet + "], " + "size = " + this.size;
  }
}
