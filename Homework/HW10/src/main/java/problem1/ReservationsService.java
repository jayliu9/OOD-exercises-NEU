package problem1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservationsService {

  public static void call(String[] tokens, Theater theater)
      throws NotEnoughSeatsException, InvalidInputException {
    Processor processor = ProcessorFactory.makeProcessor(tokens, theater);
    processor.execute();
  }

  private static class ProcessorFactory {

    private static Processor makeProcessor(String[] tokens, Theater theater) {
      switch (tokens[0]) {
        case Constants.RESERVE:
          return new Reservation(Integer.valueOf(tokens[1]), theater);
        case Constants.SHOW:
          return new Display(theater);
        default:
          return new Skip();
      }
    }
  }

  private interface Processor {

    Boolean execute() throws NotEnoughSeatsException, InvalidInputException;
  }

  private static class Reservation implements Processor {

    private Integer neededSeats;
    private Theater theater;

    public Reservation(Integer neededSeats, Theater state) {
      this.neededSeats = neededSeats;
      this.theater = state;
    }

    private void checkAnswer(String answer) throws InvalidInputException {
      if (!answer.equals("yes") && !answer.equals("no")) {
        throw new InvalidInputException();
      }
    }

    private List<Integer> convertToRowIndexes(List<Integer> list) {
      return list.stream()
          .map(i -> i - 1)
          .collect(Collectors.toList());
    }

    private List<Integer> getIndexesOfNotAccessibleRows(List<Integer> indexesOfAccessibleRows) {
      return Stream.iterate(0, i -> i + 1)
          .limit(this.theater.getNumOfRows())
          .filter(i -> !indexesOfAccessibleRows.contains(i))
          .collect(Collectors.toList());
    }

    private List<Integer> getLineOrder() throws InvalidInputException {
      Scanner console = new Scanner(System.in);
      System.out.println("Do you need wheelchair accessible seats?");
      String answer = console.nextLine();
      List<Integer> indexesOfAccessibleRows = this.convertToRowIndexes(this.theater.getLinesWheelchairAccessible());

      this.checkAnswer(answer);

      List<Integer> sortedList = this.sort(indexesOfAccessibleRows);
      if (answer.equals("no")) {
        List<Integer> indexesOfNotAccessibleRows = this.getIndexesOfNotAccessibleRows(indexesOfAccessibleRows);
        List<Integer> sortedIndexesOfNotAccessibleRows = this.sort(indexesOfNotAccessibleRows);
        sortedList = Stream.of(sortedIndexesOfNotAccessibleRows, sortedList)
            .flatMap(x -> x.stream())
            .collect(Collectors.toList());
      }
      return sortedList;
    }

    @Override
    public Boolean execute() throws NotEnoughSeatsException, InvalidInputException {
      if (this.exceedMaxSeats()) {
        throw new NotEnoughSeatsException("Sorry, we don't have that many seats together for you.");
      }
      List<Integer> sorted = this.getLineOrder();
      System.out.println("What is your name?");
      Scanner console = new Scanner(System.in);
      String reserveFor = console.nextLine();
      for (Integer rowIndex : sorted) {
        if (this.isAvailableLine(rowIndex, this.neededSeats)) {
          this.theater.updateSeating(rowIndex, this.findFirstEmptySeat(rowIndex), this.neededSeats,
              reserveFor);
          System.out.println("I've reserved "
              + this.neededSeats + " seats for you at "
              + this.theater.getName() + " in row "
              + (rowIndex + 1) + ", " + reserveFor
              + "." + System.lineSeparator());
          return true;
        }
      }
      throw new NotEnoughSeatsException("Sorry, we don't have that many seats together for you.");
    }

    private Boolean exceedMaxSeats() {
      return this.neededSeats > this.theater.getNumOfSeatsInRow();
    }

    private List<Integer> sort(List<Integer> rows) {
      List<Integer> listToSort = rows.stream().collect(Collectors.toList());
      Collections.sort(listToSort, new OptimalLineComparator());
      return listToSort;
    }

    private Boolean isAvailableLine(Integer row, Integer neededSeats) {
      if (this.findFirstEmptySeat(row).equals(Constants.INVALID_COL)) {
        return false;
      }
      return neededSeats <= this.theater.getNumOfSeatsInRow() - this.findFirstEmptySeat(row);
    }

    private Integer findFirstEmptySeat(Integer rowIndex) {
      List<Row> rows = this.theater.getRows();
      Row rowToFind = rows.get(rowIndex);
      int index = 0;
      for (Seat s : rowToFind) {
        if (this.isSeatEmpty(s)) {
          return index;
        }
        index++;
      }
      return Constants.INVALID_COL;
    }

    private Boolean isSeatEmpty(Seat seat) {
      return seat.getReserveFor() == null;
    }

    private class OptimalLineComparator implements Comparator<Integer> {

      @Override
      public int compare(Integer o1, Integer o2) {
        Integer center = (theater.getNumOfRows() - 1) / 2;
        return Integer.compare(Math.abs(o1 - center), Math.abs(o2 - center));
      }
    }
  }

  public static class Display implements Processor {

    private Theater theater;

    public Display(Theater theater) {
      this.theater = theater;
    }

    @Override
    public Boolean execute() {
      System.out.println(SeatMap.createMap(this.theater.getRows()));
      return true;
    }
  }

  public static class Skip implements Processor {

    @Override
    public Boolean execute() throws InvalidInputException {
      throw new InvalidInputException();
    }
  }
}
