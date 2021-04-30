package problem1;

import java.util.ArrayList;
import java.util.Formatter;

public class Row extends ArrayList<Seat>{

  private static final Integer A_ASCII = 65;
  private Integer rowNum;
  private Integer numOfSeats;
  private Boolean wheelchairAccessible;

  private Row(Builder builder) {
    this.rowNum = builder.rowNum;
    this.numOfSeats = builder.numOfSeats;
    this.wheelchairAccessible = builder.wheelchairAccessible;
    this.populateSeatState();
  }

  private void populateSeatState() {
    for (int c = 0; c < numOfSeats; c++) {
      Seat seat = this.wheelchairAccessible ?
          new WheelchairAccessibleSeat(String.valueOf((char) (65 + c)))
          : new Seat(String.valueOf((char) (65 + c)));
      this.add(seat);
    }
  }

  @Override
  public String toString() {
    String begin = String.format("%-2d", this.rowNum);
    StringBuilder sb = new StringBuilder();
    sb.append(begin);
    for (Seat s : this) {
      sb.append(" " + s.toString());
    }
    return sb.toString();
  }

  public static class Builder {
    private Integer rowNum;
    private Integer numOfSeats;
    private Boolean wheelchairAccessible;

    public Builder(Integer numOfSeats, Boolean wheelchairAccessible) {
      this.numOfSeats = numOfSeats;
      this.wheelchairAccessible = wheelchairAccessible;
    }

    public Builder addRowNum(Integer rowNum) {
      this.rowNum = rowNum;
      return this;
    }

    public Row build() {
      return new Row(this);
    }
  }
}
