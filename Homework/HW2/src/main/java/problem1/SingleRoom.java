package problem1;

public class SingleRoom extends Room {

  private static final Integer ONE_PERSON_ONLY = 1;

  public SingleRoom(Float price) {
    super(ONE_PERSON_ONLY, price);
  }
}
