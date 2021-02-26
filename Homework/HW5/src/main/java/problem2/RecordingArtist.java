package problem2;

public class RecordingArtist extends IndividualPerson {

  @Override
  public String toString() {
    return "RecordingArtist{" +
        "firstName='" + this.getFirstName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}
