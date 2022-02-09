package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TravelerTest {

  Traveler hello;
  Destination venice;
  Destination paris;

  Traveler same;

  @Before
  public void setUp() throws Exception {
    venice = new Destination("Venice", "ITALY", "1111", 7000.0f);
    paris = new Destination("Paris", "FRANCE", "2222", 9500.0f);
    List<Destination> oneList = new ArrayList<>();
    oneList.add(venice);
    oneList.add(paris);

    hello = new Traveler("Hello", "World", oneList);
    same = new Traveler("Hello", "World", oneList);
  }

  @Test
  public void getFirstName() {
    assertEquals("Hello", hello.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("World", hello.getLastName());
  }

  @Test
  public void traveledDestinations() {
    List<Destination> test = new ArrayList<>();
    Destination veniceSame = new Destination("Venice", "ITALY", "1111", 7000.0f);
    Destination parisSame = new Destination("Paris", "FRANCE", "2222", 9500.0f);
    test.add(veniceSame);
    test.add(parisSame);
    assertEquals(test, hello.traveledDestinations());
  }

  @Test
  public void compareTo() {
    Destination seattle = new Destination("Seattle", "US", "9876", 0.0f);
    Destination boston = new Destination("Boston", "US", "6666", 1200.0f);

    List<Destination> sameSize = new ArrayList<>();
    sameSize.add(seattle);
    sameSize.add(boston);

    List<Destination> more = new ArrayList<>();
    more.add(venice);
    more.add(paris);
    more.add(seattle);

    List<Destination> less = new ArrayList<>();
    less.add(venice);
    Traveler tieBreak = new Traveler("Good Morning", "World", sameSize);
    Traveler lessDestinations = new Traveler("Good Morning", "World", less);
    Traveler moreDestinations = new Traveler("Hi", "World", more);

    assertEquals(0, hello.compareTo(same));
    assertEquals(1, hello.compareTo(lessDestinations));
    assertEquals(-1, hello.compareTo(moreDestinations));
    assertEquals(1, hello.compareTo(tieBreak));
  }
}