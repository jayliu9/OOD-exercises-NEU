package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import problem1.Athlete;
import problem1.Name;

public class AthleteTest {
  Athlete withLeague;
  Athlete withoutLeague;

  @Before
  public void setUp() throws Exception {
    Name harry = new Name("Harry", "Potter");
    Name james = new Name("James", "Bond");
    withLeague = new Athlete(harry, 179.03, 160.5,"Running");
    withoutLeague = new Athlete(james, 188.47, 174.3);
  }

  @Test
  public void getAthletesName() {
    assertEquals("Harry", withLeague.getAthletesName().getFirstName());
    assertEquals("Potter", withLeague.getAthletesName().getLastName());
  }

  @Test
  public void getHeight() {
    assertEquals(Double.valueOf(179.03), withLeague.getHeight());
  }

  @Test
  public void getWeight() {
    assertEquals(Double.valueOf(160.5), withLeague.getWeight());
  }

  @Test
  public void getLeague() {
    assertEquals("Running", withLeague.getLeague());
    assertEquals(null, withoutLeague.getLeague());
  }
}