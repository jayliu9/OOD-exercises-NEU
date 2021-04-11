package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TravelerIteratorTest {
  TravelerIterator allOutside;
  TravelerIterator noOutside;
  TravelerIterator mixed;
  Destination seattle;
  Destination venice;
  Destination paris;
  Destination boston;
  Traveler harry;
  Traveler hello;
  Traveler world;
  Traveler person;
  List<Traveler> a;
  List<Traveler> b;
  List<Traveler> c;

  @Before
  public void setUp() throws Exception {
    List<Destination> oneList = new ArrayList<>();
    seattle = new Destination("Seattle", "US", "9876", 0.0f);
    venice = new Destination("Venice", "ITALY", "1111", 7000.0f);
    paris = new Destination("Paris", "FRANCE", "2222", 9500.0f);
    boston = new Destination("Boston", "US", "6666", 1200.0f);
    oneList.add(venice);
    oneList.add(paris);

    List<Destination> allDomestic = new ArrayList<>();
    allDomestic.add(seattle);
    allDomestic.add(boston);

    List<Destination> anotherList = new ArrayList<>();
    anotherList.add(boston);
    anotherList.add(seattle);
    anotherList.add(paris);

    List<Destination> oneDomestic = new ArrayList<>();
    oneDomestic.add(boston);

    harry = new Traveler("Harry", "Potter", allDomestic);
    hello = new Traveler("Hello", "World", oneList);
    world = new Traveler("World", "Hello", anotherList);
    person = new Traveler("A", "B", oneDomestic);

    a = new ArrayList<>();
    a.add(hello);
    b = new ArrayList<>();
    b.add(harry);
    b.add(person);
    c = new ArrayList<>();
    c.add(hello);
    c.add(person);
    c.add(world);
    c.add(harry);

    allOutside = new TravelerIterator(a);
    noOutside = new TravelerIterator(b);
    mixed = new TravelerIterator(c);
  }

  @Test
  public void allOutside() {
    List<Traveler> test = new ArrayList<>();
    for (TravelerIterator it = allOutside; it.hasNext();) {
      test.add(it.next());
    }

    List<Traveler> check = new ArrayList<>();
    assertEquals(check, test);
  }

  @Test
  public void mixed() {
    List<Traveler> test = new ArrayList<>();
    for(TravelerIterator it = mixed; it.hasNext(); ) {
      test.add(it.next());
    }

    List<Traveler> check = new ArrayList<>();
    check.add(person);
    check.add(harry);

    assertEquals(check, test);
  }

  @Test
  public void noOutside() {
    List<Traveler> test = new ArrayList<>();
    for(TravelerIterator it = noOutside; it.hasNext(); ) {
      test.add(it.next());
    }

    List<Traveler> check = new ArrayList<>();
    check.add(harry);
    check.add(person);

    assertEquals(check, test);
  }
}