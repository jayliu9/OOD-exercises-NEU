package problem1;

import java.util.Objects;

/**
 * Represents a musician. Musician is the subclass of AbstractArtist.
 */
public class Musician extends AbstractArtist {

  private String recordingCompany;
  private String lastRecordAlbum;

  /**
   * Constructor for the Musician class
   * @param name The name of the musician
   * @param age The age of the musician
   * @param genres The musician's genres
   * @param award The musician's awards
   * @param recordingCompany The musician's recording company
   * @param lastRecordAlbum The title of the latest recorded album
   */
  public Musician(Name name, Integer age, String[] genres, String[] award,
      String recordingCompany, String lastRecordAlbum) {
    super(name, age, genres, award);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  /**
   * Adds an received award to their current array of awards.
   * @param award The received award
   * @return A new Musician object with new array of awards.
   */
  @Override
  public Musician receiveAward(String award) {
    int sourceListLength = this.getAward().length;
    String[] newList = new String[sourceListLength + 1];
    System.arraycopy(this.getAward(), 0, newList, 0, sourceListLength);
    newList[sourceListLength] = award;
    return new Musician(this.getName(), this.getAge(), this.getGenres(), newList,
        this.recordingCompany, this.lastRecordAlbum);
  }

  /**
   * Gets the musician's recording company
   * @return The musician's recording company
   */
  public String getRecordingCompany() {
    return this.recordingCompany;
  }

  /**
   * Gets the title of the latest recorded album
   * @return The title of the latest recorded album
   */
  public String getLastRecordAlbum() {
    return this.lastRecordAlbum;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (!super.equals(o)) {
      return false;
    }
    Musician musician = (Musician) o;
    return this.recordingCompany.equals(musician.recordingCompany) && this.lastRecordAlbum
        .equals(musician.lastRecordAlbum);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.recordingCompany, this.lastRecordAlbum);
  }

  /**
   * Creates a string representation of the Musician.
   * @return a string representation of the Musician.
   */
  @Override
  public String toString() {
    return "Musician: " + super.toString() +
        ", recordingCompany=" + this.recordingCompany +
        ", lastRecordAlbum=" + this.lastRecordAlbum;
  }
}
