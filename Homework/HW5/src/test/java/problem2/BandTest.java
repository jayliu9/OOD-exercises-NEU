package problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class BandTest {

  Band band;
  Band same;
  Band nullBand;
  Band differentName;
  Band differentMembers;
  RecordingArtist first;
  RecordingArtist second;
  RecordingArtist third;

  @Before
  public void setUp() throws Exception {
    band = new Band("New Band");
    first = new RecordingArtist("A", "B");
    second = new RecordingArtist("C", "D");
    band.addMember(first);
    band.addMember(second);

    Set<RecordingArtist> members = new HashSet<>();
    members.add(second);
    members.add(first);
    same = new Band("New Band", members);
    nullBand = null;
    differentName = new Band("Band", members);
    third = new RecordingArtist("E", "F");
    Set<RecordingArtist> testMembers = new HashSet<>();
    testMembers.add(first);
    testMembers.add(third);
    differentMembers = new Band("New Band", testMembers);
  }

  @Test
  public void removeMember() throws InvalidRemovalException {
    RecordingArtist testFirst = new RecordingArtist("A", "B");
    band.removeMember(testFirst);
    Band removed = new Band("New Band");
    RecordingArtist testSecond = new RecordingArtist("C", "D");
    removed.addMember(testSecond);
    assertEquals(removed, band);
  }

  @Test
  public void isExactMatch() {
    RecordingArtist match = new RecordingArtist("A", "B");
    RecordingArtist noMatch = new RecordingArtist("B", "A");
    assertTrue(band.isExactMatch(match));
    assertFalse(band.isExactMatch(noMatch));
  }

  @Test
  public void testEquals() {
    assertTrue(band.equals(same));
    assertTrue(band.equals(band));
    assertFalse(band.equals(nullBand));
    assertFalse(band.equals(first));
    assertFalse(band.equals(differentName));
    assertFalse(band.equals(differentMembers));
  }

  @Test
  public void testHashCode() {
    assertTrue(band.hashCode() == same.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Band{name='New Band'"
        + ", members=[RecordingArtist{firstName='A', lastName='B'}"
        + ", RecordingArtist{firstName='C', lastName='D'}]}", band.toString());
  }

  @Test(expected = InvalidRemovalException.class)
  public void invalidRemoval() throws InvalidRemovalException {
    band.removeMember(third);
  }
}