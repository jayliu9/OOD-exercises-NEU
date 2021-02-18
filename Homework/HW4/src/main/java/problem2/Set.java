package problem2;

import problem1.Course;

public class Set implements ISet {
  private int size;
  private Integer[] items;
  private static final int DEFAULT_NUM_OF_SLOTS = 5;

  /**
   * Constructor for the Set class
   */
  public Set() {
    this.size = 0;
    this.items = new Integer[DEFAULT_NUM_OF_SLOTS];
  }

  /**
   * Private constructor that allows us to return a new copy from the producers.
   * @param size The size of the set
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
  @Override
  public Set emptySet() {
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
    for (int i = 0; i < from.length; i++) {
      to[i] = from[i];
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
    for (int i = 0; i < this.size; i++) {
      if (n.equals(this.items[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * Removes the given integer from the set.
   * @param n The integer to remove
   * @return A copy of the set with the given integer removed. If the integer is not in the set,
   * returns the set as is.
   */
  @Override
  public Set remove(Integer n) {
    if (!this.contains(n)) {
      return new Set(this.size, this.items.clone());
    }
    
    return ;
  }

  /**
   * Gets the number of items in the set
   * @return The number of items in the set
   */
  @Override
  public Integer size() {
    return this.size;
  }
}
