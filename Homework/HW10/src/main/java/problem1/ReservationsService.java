package problem1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class contains the actual services
 */
public class ReservationsService {

  private static final Integer INVALID_COL = -1;

  /**
   * Reserves the given number of seats in the given theater, based on the choice on
   * wheelchair-accessible seats and the name of the person for whom these seats are reserved
   *
   * @param theater     The theater
   * @param neededSeats The number of seats to reserve
   * @param answer      The choice of whether wheelchair-accessible seats are required
   * @param reserveFor  The name of the person for whom these seats are reserved
   * @return true if this reservation is successful
   * @throws NotEnoughSeatsException if no enough seats exist in the theater for this reservation
   */
  public Boolean reserve(Theater theater, Integer neededSeats, String answer, String reserveFor)
      throws NotEnoughSeatsException {
    List<Integer> sorted = this.prioritizeRows(theater, answer);

    for (Integer rowIndex : sorted) {
      if (this.isAvailableLine(theater, rowIndex, neededSeats)) {
        theater.updateSeating(rowIndex, this.findFirstEmptySeat(theater, rowIndex), neededSeats,
            reserveFor);
        System.out.println("I've reserved "
            + neededSeats + " seats for you at "
            + theater.getName() + " in row "
            + (rowIndex + 1) + ", " + reserveFor
            + "." + System.lineSeparator());
        return true;
      }
    }
    throw new NotEnoughSeatsException();
  }

  /**
   * Checks that if the answer for the choice of whether wheelchair-accessible seats are required is
   * valid
   *
   * @param answer The answer for the choice of whether wheelchair-accessible seats are required
   * @throws InvalidAnswerException if the answer for the choice of whether wheelchair-accessible
   *                                seats are required is invalid
   */
  public void checkAnswer(String answer) throws InvalidAnswerException {
    if (!answer.equals("yes") && !answer.equals("no")) {
      throw new InvalidAnswerException();
    }
  }

  /**
   * Helper function to convert a list of row numbers into their indexes in the list
   *
   * @param list The list of row numbers
   * @return A list of indexes of rows in the list
   */
  private List<Integer> convertToRowIndexes(List<Integer> list) {
    return list.stream()
        .map(i -> i - 1)
        .collect(Collectors.toList());
  }

  /**
   * Helper function to get a list of indexes of not wheelchair-accessible rows in a theater
   *
   * @param t                       The theater
   * @param indexesOfAccessibleRows The list of indexes of accessible rows
   * @return A list of indexes of not wheelchair-accessible rows in a theater
   */
  private List<Integer> getIndexesOfNotAccessibleRows(Theater t,
      List<Integer> indexesOfAccessibleRows) {
    return Stream.iterate(0, i -> i + 1)
        .limit(t.getNumOfRows())
        .filter(i -> !indexesOfAccessibleRows.contains(i))
        .collect(Collectors.toList());
  }

  /**
   * Prioritizes the rows based on the answer for the choice of whether wheelchair-accessible seats
   * are required. If and only if all other rows are occupied, then the system will reserve seats in
   * accessible rows to users who do not need accessible seats.
   *
   * @param t      The theater
   * @param answer The answer for the choice of whether wheelchair-accessible seats are required
   * @return The list of indexes of rows sorted by priority about the reservation
   */
  private List<Integer> prioritizeRows(Theater t, String answer) {
    List<Integer> indexesOfAccessibleRows = this
        .convertToRowIndexes(t.getLinesWheelchairAccessible());

    List<Integer> sortedList = this.sortByProximity(t, indexesOfAccessibleRows);

    if (answer.equals("no")) {
      List<Integer> indexesOfNotAccessibleRows = this
          .getIndexesOfNotAccessibleRows(t, indexesOfAccessibleRows);
      List<Integer> sortedIndexesOfNotAccessibleRows = this
          .sortByProximity(t, indexesOfNotAccessibleRows);
      sortedList = Stream.of(sortedIndexesOfNotAccessibleRows, sortedList)
          .flatMap(x -> x.stream())
          .collect(Collectors.toList());
    }
    return sortedList;
  }

  /**
   * Checks that the needed number of seats is valid
   *
   * @param t           The theater
   * @param neededSeats The needed number of seats
   * @throws NotEnoughSeatsException    if the needed number of seats exceeds the maximum number of
   *                                    seats in a row in a theater
   * @throws InvalidNumOfSeatsException if the needed number of seats is 0
   */
  public void checkNeededSeats(Theater t, Integer neededSeats)
      throws NotEnoughSeatsException, InvalidNumOfSeatsException {
    if (this.exceedMaxSeats(t, neededSeats)) {
      throw new NotEnoughSeatsException();
    }
    if (neededSeats == 0) {
      throw new InvalidNumOfSeatsException();
    }
  }

  /**
   * Checks whether the needed number of seats exceeds the maximum number of seats in a row in a
   * theater
   *
   * @param t           The theater
   * @param neededSeats The number of needed seats
   * @return true if the needed number of seats exceeds the maximum number of seats in a row in a
   * theater, false otherwise
   */
  private Boolean exceedMaxSeats(Theater t, Integer neededSeats) {
    return neededSeats > t.getNumOfSeatsInRow();
  }


  /**
   * Gets a sorted list of rows based on the proximity to the center row
   *
   * @param t    The theater
   * @param rows The list of rows to sort
   * @return The sorted list of rows
   */
  private List<Integer> sortByProximity(Theater t, List<Integer> rows) {
    List<Integer> listToSort = rows.stream().collect(Collectors.toList());
    Collections.sort(listToSort, new OptimalLineComparator(t));
    return listToSort;
  }

  /**
   * Checks whether a row has enough available seats for the number of needed seats.
   *
   * @param t           The theater
   * @param row         The index of a row to check
   * @param neededSeats The number of needed seats
   * @return true if the row has enough available seats for the number of needed seats, false
   * otherwise
   */
  private Boolean isAvailableLine(Theater t, Integer row, Integer neededSeats) {
    if (this.findFirstEmptySeat(t, row).equals(INVALID_COL)) {
      return false;
    }
    return neededSeats <= t.getNumOfSeatsInRow() - this.findFirstEmptySeat(t, row);
  }

  /**
   * Finds the index of the first available seat in a given row
   *
   * @param t        The theater
   * @param rowIndex The index of a row to find
   * @return The index of the first available seat in the given row, if all the seats in the row is
   * occupied, return default value, -1.
   */
  private Integer findFirstEmptySeat(Theater t, Integer rowIndex) {
    List<Row> rows = t.getRows();
    Row rowToFind = rows.get(rowIndex);
    int index = 0;
    for (Seat s : rowToFind) {
      if (this.isSeatEmpty(s)) {
        return index;
      }
      index++;
    }
    return INVALID_COL;
  }

  /**
   * Displays the current available seating in the theater
   *
   * @param t The theater
   */
  public void show(Theater t) {
    System.out.println(SeatingHelper.createMap(t.getRows()));
  }

  /**
   * Checks if the seat is empty
   *
   * @param seat The seat to check
   * @return true if the seat is empty, false otherwise
   */
  private Boolean isSeatEmpty(Seat seat) {
    return seat.getReserveFor() == null;
  }

  private class OptimalLineComparator implements Comparator<Integer> {

    private Theater t;

    public OptimalLineComparator(Theater t) {
      this.t = t;
    }

    /**
     * Compares integers based on based on the proximity to the center row
     *
     * @param o1 The integer to compare
     * @param o2 The other integer to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than,
     * equal to, or greater than the second.
     */
    @Override
    public int compare(Integer o1, Integer o2) {
      Integer center = (t.getNumOfRows() - 1) / 2;
      return Integer.compare(Math.abs(o1 - center), Math.abs(o2 - center));
    }
  }
}

