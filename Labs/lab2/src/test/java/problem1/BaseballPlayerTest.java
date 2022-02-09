package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.BaseballPlayer;
import problem1.Name;

public class BaseballPlayerTest {
  BaseballPlayer player;
  BaseballPlayer noLeague;

  @Before
  public void setUp() throws Exception {
    Name name = new Name("Hello", "World");
    Name noLeagueName = new Name("No", "League");
    player = new BaseballPlayer(name, 181.32, 157.6, "Baseball", "A", 0.196, 50);
    noLeague = new BaseballPlayer(noLeagueName, 175.49, 155.9, "H", 0.187, 47);
  }

  @Test
  public void getTeam() {
    assertEquals("A", player.getTeam());
  }

  @Test
  public void setTeam() {
    player.setTeam("Z");
    assertEquals("Z", player.getTeam());
  }

  @Test
  public void getAverageBatting() {
    assertEquals(Double.valueOf(0.196), player.getAverageBatting());
  }

  @Test
  public void setAverageBatting() {
    player.setAverageBatting(0.200);
    assertEquals(Double.valueOf(0.200), player.getAverageBatting());
  }

  @Test
  public void getSeasonHomeRun() {
    assertEquals(Integer.valueOf(50), player.getSeasonHomeRun());

  }

  @Test
  public void setSeasonHomeRun() {
    player.setSeasonHomeRun(35);
    assertEquals(Integer.valueOf(35), player.getSeasonHomeRun());
  }
}