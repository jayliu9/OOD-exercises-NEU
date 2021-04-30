package problem1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents a row in the theater. This class extends ArrayList of Seat objects.
 */
public class Row extends ArrayList<Seat> {

  private static final Integer A_ASCII = 65;
  private Integer rowNum;
  private Integer numOfSeats;
  private Boolean wheelchairAccessible;

  /**
   * Constructor for the Row class
   *
   * @param builder The builder of the Row
   */
  private Row(Builder builder) {
    this.rowNum = builder.rowNum;
    this.numOfSeats = builder.numOfSeats;
    this.wheelchairAccessible = builder.wheelchairAccessible;
    this.populateSeatState();
  }

  /**
   * Populates the seats in this row.
   */
  private void populateSeatState() {
    for (int c = 0; c < numOfSeats; c++) {
      Seat seat = this.wheelchairAccessible ?
          new WheelchairAccessibleSeat(String.valueOf((char) (A_ASCII + c)))
          : new Seat(String.valueOf((char) (A_ASCII + c)));
      this.add(seat);
    }
  }

  /**
   * Checks if two objects are equal
   *
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Row seats = (Row) o;
    return rowNum.equals(seats.rowNum) && numOfSeats.equals(seats.numOfSeats)
        && wheelchairAccessible
        .equals(seats.wheelchairAccessible);
  }

  /**
   * Gets a hash code value for the object.
   *
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), rowNum, numOfSeats, wheelchairAccessible);
  }

  /**
   * Creates a string representation of the Row.
   *
   * @return a string representation of the Row.
   */
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

  /**
   * Uses the builder pattern to handle construction of a Row object.
   */
  public static class Builder {

    private Integer rowNum;
    private Integer numOfSeats;
    private Boolean wheelchairAccessible;

    /**
     * Constructor for the Builder class
     *
     * @param numOfSeats           The number of seats per row
     * @param wheelchairAccessible The Boolean of whether the row is wheelchair-accessible
     */
    public Builder(Integer numOfSeats, Boolean wheelchairAccessible) {
      this.numOfSeats = numOfSeats;
      this.wheelchairAccessible = wheelchairAccessible;
    }

    /**
     * Adds the field of row number to the Row object
     *
     * @param rowNum The row number
     * @return The builder
     */
    public Builder addRowNum(Integer rowNum) {
      this.rowNum = rowNum;
      return this;
    }

    /**
     * Completes the builder
     *
     * @return the Row object
     */
    public Row build() {
      return new Row(this);
    }
  }
}
