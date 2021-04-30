package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationSystem {

  public static void main(String[] args) {
    List<Integer> rowsForWheelchair = new ArrayList<>();
    rowsForWheelchair.add(1);
    rowsForWheelchair.add(5);
    rowsForWheelchair.add(10);
    Theater theater = new Theater("Roxy", 15, 10, rowsForWheelchair);
    Scanner console = new Scanner(System.in);

    System.out.println("What would you like to do?");
    String cmd = console.nextLine();

    while (!cmd.equals(Constants.END)) {
      try {
        String[] tokens = cmd.split(" ");
        ReservationsService.call(tokens, theater);
      } catch (NotEnoughSeatsException | InvalidInputException e) {
        System.out.println(e.getMessage());
      }
      System.out.println("What would you like to do?");
      cmd = console.nextLine();
    }
    System.out.println("Have a nice day!");
  }
}
