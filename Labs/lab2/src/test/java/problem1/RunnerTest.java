package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Name;
import problem1.Runner;

public class RunnerTest {
  Runner runner;
  Runner noLeague;

  @Before
  public void setUp() throws Exception {
    Name harry = new Name("Harry", "Potter");
    Name noLeagueName = new Name("No", "League");

    runner = new Runner(harry, 180.19, 160.5, "Running", 15.06, 75.77, "half marathon");
    noLeague = new Runner(noLeagueName, 175.49, 155.9, 19.77, 90.16, "full marathon");
  }

  @Test
  public void getBest5KTime() {
    assertEquals(Double.valueOf(15.06), runner.getBest5KTime());
  }

  @Test
  public void setBest5KTime() {
    runner.setBest5KTime(14.92);
    assertEquals(Double.valueOf(14.92), runner.getBest5KTime());
  }

  @Test
  public void getHalfMarathonTime() {
    assertEquals(Double.valueOf(75.77), runner.getHalfMarathonTime());
  }

  @Test
  public void setHalfMarathonTime() {
    runner.setHalfMarathonTime(68.61);
    assertEquals(Double.valueOf(68.61), runner.getHalfMarathonTime());
  }

  @Test
  public void getFavoriteRunningEvent() {
    assertEquals("half marathon", runner.getFavoriteRunningEvent());
  }

  @Test
  public void setFavoriteRunningEvent() {
    runner.setFavoriteRunningEvent("full marathon");
    assertEquals("full marathon", runner.getFavoriteRunningEvent());
  }
}