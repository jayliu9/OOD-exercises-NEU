package problem2;

/**
 * Required operations for a bog of words.
 */
public interface IBagOfWords {

  /**
   * Creates an empty BagOfWords
   * @return An empty BagOfWords
   */
  static IBagOfWords emptyBagOfWords() {
    return new BagOfWords();
  }

  /**
   * Checks if the BagOfWords is empty
   * @return true if the BagOfWords contains no items, false otherwise
   */
  Boolean isEmpty();

  /**
   * Gets the number of elements in the BagOfWords. Duplicates should be counted as separate
   * elements
   * @return The number of elements in the BagOfWords
   */
  Integer size();

  /**
   * Gets a new BagOfWord that contains all elements in the original BagOfWords plus s
   * @param s The element to add
   * @return A new BagOfWord that contains all elements in the original BagOfWords plus s
   */
  IBagOfWords add(String s);

  /**
   * Checks if s is in the BagOfWords.
   * @param s The element to check
   * @return true if the BagOfWords contains s, false otherwise
   */
  Boolean contains(String s);
}
