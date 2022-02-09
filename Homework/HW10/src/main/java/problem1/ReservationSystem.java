package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {

  public static final String END = "done";
  public static final String RESERVE = "reserve";
  public static final String SHOW = "show";

  public static void main(String[] args) throws NoAccessibleRowException {

    List<Integer> rowsForWheelchair = new ArrayList<>();
    rowsForWheelchair.add(1);
    rowsForWheelchair.add(5);
    rowsForWheelchair.add(10);
    Theater theater = new Theater("Roxy", 15, 10, rowsForWheelchair);
    Scanner console = new Scanner(System.in);

    System.out.println("What would you like to do?");
    String cmd = console.nextLine();
    ReservationsService r = new ReservationsService();

    while (!cmd.equals(END)) {
      try {
        String[] tokens = cmd.split(" ");
        if (tokens[0].equals(RESERVE) && tokens.length > 1 && tokens[1].matches("^[0-9]*$")) {
          Integer neededSeats = Integer.valueOf(tokens[1]);
          r.checkNeededSeats(theater, neededSeats);

          System.out.println("Do you need wheelchair accessible seats?");
          String answer = console.nextLine();
          r.checkAnswer(answer);

          System.out.println("What is your name?");
          String name = console.nextLine();

          r.reserve(theater, neededSeats, answer, name);
        } else if (tokens[0].equals(SHOW)) {
          r.show(theater);
        } else {
          System.out.println("Invalid Input! Please try again!");
        }
      } catch (NotEnoughSeatsException | InvalidAnswerException | InvalidNumOfSeatsException e) {
        System.out.println(e.getMessage());
      }
      System.out.println("What would you like to do?");
      cmd = console.nextLine();
    }
    System.out.println("Have a nice day!");
  }
}
