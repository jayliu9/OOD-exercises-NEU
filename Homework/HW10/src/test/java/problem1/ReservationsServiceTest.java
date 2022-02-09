package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ReservationsServiceTest {
  Theater t;
  ReservationsService r;


  @Before
  public void setUp() throws Exception {
    List<Integer> rowsForWheelchair = new ArrayList<>();
    rowsForWheelchair.add(10);
    t = new Theater("A", 15, 10, rowsForWheelchair);
    r = new ReservationsService();
  }

  @Test
  public void reserve() throws NotEnoughSeatsException {
    assertTrue(r.reserve(t, 7, "no", "Sara"));
    assertTrue(r.reserve(t, 7, "yes", "Tony"));
  }

  @Test
  public void show() throws NotEnoughSeatsException {
    r.show(t);
    r.reserve(t, 7, "yes", "Tony");
    r.show(t);
    r.reserve(t, 7, "no", "Sara");
    r.show(t);
  }

  @Test(expected = NotEnoughSeatsException.class)
  public void noEnoughSeats() throws NotEnoughSeatsException {
    r.reserve(t, 7, "yes", "Tony");
    r.reserve(t, 8, "yes", "Sara");
  }

  @Test(expected = InvalidNumOfSeatsException.class)
  public void zeroSeatsToReserve() throws InvalidNumOfSeatsException, NotEnoughSeatsException {
    r.checkNeededSeats(t, 0);
  }

  @Test(expected = NotEnoughSeatsException.class)
  public void tooMuchSeatsToReserve() throws InvalidNumOfSeatsException, NotEnoughSeatsException {
    r.checkNeededSeats(t, 50);
  }

  @Test(expected = InvalidAnswerException.class)
  public void invalidAnswer() throws InvalidAnswerException {
    r.checkAnswer("Hello");
  }
}