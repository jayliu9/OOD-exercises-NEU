package problem2;

public class Music extends AbstractItem {

  public Music(RecordingArtist artist, String title, int year) {
    super(artist, title, year);
  }

  public Music(Band band, String title, int year) {
    super(band, title, year);
  }

  @Override
  public String toString() {
    return "Music{" +
        "creator=" + this.getCreator() +
        ", title='" + this.getTitle() + '\'' +
        ", year=" + this.getYear() +
        '}';
  }
}
