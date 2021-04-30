package problem1;

import java.util.List;

/**
 * Draws a seating map for the theater
 */
public class SeatingHelper {

  /**
   * Private Constructor for the SeatingHelper class
   */
  private SeatingHelper() {
  }

  /**
   * Create a String representation of a seating map
   *
   * @param rows The list of rows representing the seating state
   * @return A String representation of the seating map
   */
  public static String createMap(List<Row> rows) {
    String seating = "";
    for (Row r : rows) {
      seating += r.toString() + System.lineSeparator();
    }
    return seating;
  }
}
