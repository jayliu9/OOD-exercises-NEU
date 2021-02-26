package problem2;

/**
 * An interface specifying required behaviors for a item in the library
 */
public interface Item {

  /**
   * Checks if the title of the item has the given keyword, which is case insensitive.
   * @param keyword The keyword to check
   * @return true if the item has the given keyword, false otherwise.
   */
  boolean hasKeyword(String keyword);

  /**
   * Checks if the item has the exact match for the specified person
   * @param person The person to check
   * @return true if the item has the exact match for the specified person, false otherwise.
   */
  boolean hasCreator(Creator person);
}
