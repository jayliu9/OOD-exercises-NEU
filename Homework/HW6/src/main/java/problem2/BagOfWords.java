package problem2;

import java.util.Objects;

public class BagOfWords implements IBagOfWords {

  IMultiset words;

  /**
   * Constructor for the BagOfWords class. This creates a new empty BagOfWords.
   */
  public BagOfWords() {
    this.words = new Empty();
  }

  /**
   * Private constructor for an BagOfWords that contains words.
   * @param words The words in the new BagOfWords.
   */
  private BagOfWords(IMultiset words) {
    this.words = words;
  }

  /**
   * Checks if the BagOfWords is empty
   * @return true if the BagOfWords contains no items, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.words.count() == 0;
  }

  /**
   * Gets the number of elements in the BagOfWords. Duplicates should be counted as separate
   * elements
   * @return The number of elements in the BagOfWords
   */
  @Override
  public Integer size() {
    return this.words.count();
  }

  /**
   * Gets a new BagOfWord that contains all elements in the original BagOfWords plus s
   * @param s The element to add
   * @return A new BagOfWord that contains all elements in the original BagOfWords plus s
   */
  @Override
  public IBagOfWords add(String s) {
    IMultiset newWords = this.words.add(s);
    return new BagOfWords(newWords);
  }

  /**
   * Checks if s is in the BagOfWords.
   * @param s The element to check
   * @return true if the BagOfWords contains s, false otherwise
   */
  @Override
  public Boolean contains(String s) {
    return this.words.contains(s);
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
    BagOfWords that = (BagOfWords) o;
    return Objects.equals(this.words, that.words);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.words);
  }

  /**
   * Returns a string representation of the BagOfWords.
   * @return a string representation of the BagOfWords.
   */
  @Override
  public String toString() {
    return "BagOfWords{" +
        "words=" + this.words +
        '}';
  }
}
