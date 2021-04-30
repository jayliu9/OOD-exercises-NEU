package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a theater
 */
public class Theater {

  private String name;
  private Integer numOfRows;
  private Integer numOfSeatsInRow;
  private List<Row> rows;
  private List<Integer> linesWheelchairAccessible;

  /**
   * Constructor for the Theater class
   *
   * @param name                      The name of the theater
   * @param numOfRows                 The number of rows in the theater
   * @param numOfSeatsInRow           The number of Seats per row in the theater
   * @param linesWheelchairAccessible A non-empty list of integers indicating which of the rows are
   *                                  wheelchair accessible
   * @throws NoAccessibleRowException if the list of integers indicating the wheelchair-accessible
   *                                  rows is empty
   */
  public Theater(String name, Integer numOfRows, Integer numOfSeatsInRow,
      List<Integer> linesWheelchairAccessible) throws NoAccessibleRowException {
    this.name = name;
    this.numOfRows = numOfRows;
    this.numOfSeatsInRow = numOfSeatsInRow;
    this.rows = new ArrayList<>();
    this.checkAtLeastOneAccessibleRow(linesWheelchairAccessible);
    this.linesWheelchairAccessible = linesWheelchairAccessible;
    this.populateRowState();
  }

  /**
   * Checks that there is at least one accessible row in the list of integers indicating the
   * wheelchair-accessible rows to check
   *
   * @param linesWheelchairAccessible The list of integers indicating the wheelchair-accessible rows
   *                                  to check
   * @throws NoAccessibleRowException if there is no at least one accessible row in the list
   */
  private void checkAtLeastOneAccessibleRow(List<Integer> linesWheelchairAccessible)
      throws NoAccessibleRowException {
    if (linesWheelchairAccessible.size() == 0) {
      throw new NoAccessibleRowException();
    }
  }

  /**
   * Populates the rows in the theater
   */
  private void populateRowState() {
    for (int r = 1; r <= this.numOfRows; r++) {
      Row row = this.linesWheelchairAccessible.contains(r) ?
          new Row.Builder(this.numOfSeatsInRow, true).addRowNum(r).build()
          : new Row.Builder(this.numOfSeatsInRow, false).addRowNum(r).build();
      this.rows.add(row);
    }
  }

  /**
   * Updates the current seating based on the given index of row, the index of seat, the number of
   * seats to reserve and the name of the person for whom they are reserved
   *
   * @param row  The index of the row to reserve
   * @param col  The index of the seat to reserve
   * @param num  The number of seats to reserve
   * @param name The name of the person for whom the seats are reserved
   */
  public void updateSeating(Integer row, Integer col, Integer num, String name) {
    Row rowToOccupy = this.rows.get(row);
    for (Integer c = col; c < num + col; c++) {
      rowToOccupy.get(c).setReserveFor(name);
    }
  }

  /**
   * Gets the current rows state
   *
   * @return The list of rows
   */
  public List<Row> getRows() {
    return this.rows;
  }

  /**
   * Gets the number of rows in the theater
   *
   * @return The number of rows in the theater
   */
  public Integer getNumOfRows() {
    return this.numOfRows;
  }

  /**
   * Gets the number of seats per row
   *
   * @return The number of seats per row
   */
  public Integer getNumOfSeatsInRow() {
    return this.numOfSeatsInRow;
  }

  /**
   * Gets the name of the theater
   *
   * @return The name of the theater
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the list of integers indicating the wheelchair-accessible rows
   *
   * @return The list of integers indicating the wheelchair-accessible rows
   */
  public List<Integer> getLinesWheelchairAccessible() {
    return this.linesWheelchairAccessible;
  }

  /**
   * Checks if two objects are equal
   *
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
    Theater theater = (Theater) o;
    return name.equals(theater.name) && numOfRows.equals(theater.numOfRows) && numOfSeatsInRow
        .equals(theater.numOfSeatsInRow) && rows.equals(theater.rows) && linesWheelchairAccessible
        .equals(theater.linesWheelchairAccessible);
  }

  /**
   * Gets a hash code value for the object.
   *
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, numOfRows, numOfSeatsInRow, rows, linesWheelchairAccessible);
  }

  /**
   * Creates a string representation of the Theater.
   *
   * @return a string representation of the Theater.
   */
  @Override
  public String toString() {
    return "Theater{" +
        "name='" + name + '\'' +
        ", numOfRows=" + numOfRows +
        ", numOfSeatsInRow=" + numOfSeatsInRow +
        ", linesWheelchairAccessible=" + linesWheelchairAccessible +
        '}';
  }
}

