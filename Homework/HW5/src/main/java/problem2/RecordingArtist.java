package problem2;

/**
 * Represents a recording artist. RecordingArtist is the subclass of IndividualPerson
 */
public class RecordingArtist extends IndividualPerson {

  /**
   * Constructor for the RecordingArtist class
   * @param firstName The first name of the recording artist
   * @param lastName The last name of the recording artist
   */
  public RecordingArtist(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Creates a string representation of the RecordingArtist.
   * @return a string representation of the RecordingArtist.
   */
  @Override
  public String toString() {
    return "RecordingArtist{" +
        "firstName='" + this.getFirstName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}
