package problem2;

/**
 * Represents Music. Music is the subclass of the AbstractItem
 */
public class Music extends AbstractItem {

  /**
   * Constructor for the Music class. This constructor version creates a new Music object
   * with a recording artist.
   * @param artist The artist as the music's creator
   * @param title The title of the music
   * @param year The year the music was released.
   */
  public Music(RecordingArtist artist, String title, int year) {
    super(artist, title, year);
  }

  /**
   * Constructor for the Music class. This constructor version creates a new Music object
   * with a band.
   * @param band The band as the music's creator
   * @param title The title of the music
   * @param year The year the music was released.
   */
  public Music(Band band, String title, int year) {
    super(band, title, year);
  }

  /**
   * Creates a string representation of the Music.
   * @return a string representation of the Music.
   */
  @Override
  public String toString() {
    return "Music{" +
        "creator=" + this.getCreator() +
        ", title='" + this.getTitle() + '\'' +
        ", year=" + this.getYear() +
        '}';
  }
}
