package problem2;

/**
 * An interface specifying required behaviors for an item's creator
 */
public interface Creator {

  /**
   * Checks if the particular person is the exact match for the creator
   * @param person The person to check
   * @return true if the person to check is the exact match for the creator, false otherwise
   */
  boolean isExactMatch(Creator person);
}
