package problem1;

public class OccupiedRoomException extends Exception {

  public OccupiedRoomException() {
    super("This room is occupied already!");
  }
}
