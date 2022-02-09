package problem1;

import java.util.Objects;

/**
 * Represents a seat
 */
public class Seat {

  private static final String EMPTY = "_";
  private static final String OCCUPIED = "X";
  private String name;
  private String reserveFor;

  /**
   * Constructor for the Seat class
   *
   * @param name The name of the seat
   */
  public Seat(String name) {
    this.name = name;
  }

  /**
   * Sets the name of the person for whom it has been reserved
   *
   * @param reserveFor The name of the person for whom it has been reserved
   */
  public void setReserveFor(String reserveFor) {
    this.reserveFor = reserveFor;
  }

  /**
   * Gets the name of the seat
   *
   * @return The name of the seat
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the name of the person for whom it has been reserved
   *
   * @return The name of the person for whom it has been reserved
   */
  public String getReserveFor() {
    return reserveFor;
  }

  /**
   * Creates a string representation of the Seat.
   *
   * @return a string representation of the Seat.
   */
  @Override
  public String toString() {
    if (this.reserveFor != null) {
      return OCCUPIED;
    }
    return EMPTY;
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
    Seat seat = (Seat) o;
    return name.equals(seat.name) && Objects.equals(reserveFor, seat.reserveFor);
  }

  /**
   * Gets a hash code value for the object.
   *
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, reserveFor);
  }
}
