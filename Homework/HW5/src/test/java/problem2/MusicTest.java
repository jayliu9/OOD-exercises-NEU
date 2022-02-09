package problem2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class MusicTest {

  Music music;

  @Before
  public void setUp() throws Exception {
    Set<RecordingArtist> members = new HashSet<>();
    RecordingArtist first = new RecordingArtist("A", "B");
    RecordingArtist second = new RecordingArtist("C", "D");
    members.add(first);
    members.add(second);
    Band band = new Band("Band", members);
    music = new Music(band, "Title", 1995);
  }

  @Test
  public void testToString() {
    assertEquals("Music{creator=Band{name='Band'"
        + ", members=[RecordingArtist{firstName='A', lastName='B'}"
        + ", RecordingArtist{firstName='C', lastName='D'}]}"
        + ", title='Title', year=1995}", music.toString());
  }
}