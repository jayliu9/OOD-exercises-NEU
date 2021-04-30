package problem1;

import java.util.List;

public class SeatMap {

  public static String createMap(List<Row> rows) {
    String seating = "";
    for (Row r : rows) {
      seating += r.toString() + System.lineSeparator();
    }
    return seating;
  }
}
