package problem1;

public class Seat {

  private static final String EMPTY = "_";
  private static final String OCCUPIED = "X";
  private String name;
  private String reserveFor;

  public Seat(String name) {
    this.name = name;
  }

  public void setReserveFor(String reserveFor) {
    this.reserveFor = reserveFor;
  }

  public String getName() {
    return name;
  }

  public String getReserveFor() {
    return reserveFor;
  }

  @Override
  public String toString() {
    if (this.reserveFor != null)
      return OCCUPIED;
    return EMPTY;
  }
}
