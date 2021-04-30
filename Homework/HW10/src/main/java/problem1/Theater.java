package problem1;

import java.util.ArrayList;
import java.util.List;
import problem1.Row.Builder;

public class Theater {

  private String name;
  private Integer numOfRows;
  private Integer numOfSeatsInRow;
  private List<Row> rows;
  private Integer bestLine;
  private List<Integer> linesWheelchairAccessible;
  private static Theater instance;

  public Theater(String name, Integer numOfRows, Integer numOfSeatsInRow,
      List<Integer> linesWheelchairAccessible) {
    this.name = name;
    this.numOfRows = numOfRows;
    this.numOfSeatsInRow = numOfSeatsInRow;
    this.rows = new ArrayList<>();
    this.linesWheelchairAccessible = linesWheelchairAccessible;
    this.populateRowState();
  }


  private void populateRowState() {
    for (int r = 1; r <= this.numOfRows; r++) {
      Row row = this.linesWheelchairAccessible.contains(r) ?
          new Builder(this.numOfSeatsInRow, true).addRowNum(r).build()
          : new Builder(this.numOfSeatsInRow, false).addRowNum(r).build();
      this.rows.add(row);
    }
  }

  public void updateSeating(Integer row, Integer col, Integer num, String name) {
    Row rowToOccupy = this.rows.get(row);
    for (Integer c = col; c < num + col; c++) {
      rowToOccupy.get(c).setReserveFor(name);
    }
  }

  public List<Row> getRows() {
    return this.rows;
  }

  public Integer getNumOfRows() {
    return this.numOfRows;
  }

  public Integer getNumOfSeatsInRow() {
    return this.numOfSeatsInRow;
  }

  public String getName() {
    return this.name;
  }

  public List<Integer> getLinesWheelchairAccessible() {
    return this.linesWheelchairAccessible;
  }
}

