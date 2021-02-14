package problem1;

import java.util.Arrays;

/**
 * Represents a performer. Performer is the subclass of AbstractArtist.
 */
public class Performer extends AbstractArtist {
  private String[] movies;
  private String[] series;
  private String[] multimedia;

  /**
   * Constructor for the Performer class
   * @param name The name of the performer
   * @param age The age of the performer
   * @param genres The performer's genres
   * @param award The performer's awards
   * @param movies All movies the performer worked on
   * @param series All TV series the performer worked on
   * @param multimedia All multimedia the performer worked on
   */
  public Performer(Name name, Integer age, String[] genres, String[] award,
      String[] movies, String[] series, String[] multimedia) {
    super(name, age, genres, award);
    this.movies = movies;
    this.series = series;
    this.multimedia = multimedia;
  }

  /**
   * Adds an received award to their current array of awards.
   * @param award The received award
   * @return A new Performer object with new array of awards.
   */
  @Override
  public Performer receiveAward(String award) {
    int sourceListLength = this.getAward().length;
    String[] newList = new String[sourceListLength + 1];
    System.arraycopy(this.getAward(), 0, newList, 0, sourceListLength);
    newList[sourceListLength] = award;
    return new Performer(this.getName(), this.getAge(), this.getGenres(), newList,
        this.movies, this.series, this.multimedia);
  }

  /**
   * Gets all movies the performer worked on
   * @return All movies the performer worked on
   */
  public String[] getMovies() {
    return this.movies;
  }

  /**
   * Gets all TV series the performer worked on
   * @return All TV series the performer worked on
   */
  public String[] getSeries() {
    return this.series;
  }

  /**
   * Gets all multimedia the performer worked on
   * @return All multimedia the performer worked on
   */
  public String[] getMultimedia() {
    return this.multimedia;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Performer performer = (Performer) o;
    return Arrays.equals(this.movies, performer.movies) && Arrays
        .equals(this.series, performer.series) && Arrays
        .equals(this.multimedia, performer.multimedia);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(this.movies);
    result = 31 * result + Arrays.hashCode(this.series);
    result = 31 * result + Arrays.hashCode(this.multimedia);
    return result;
  }

  /**
   * Creates a string representation of the Performer.
   * @return a string representation of the Performer.
   */
  @Override
  public String toString() {
    return super.toString() +
        ", movies=" + Arrays.toString(this.movies) +
        ", series=" + Arrays.toString(this.series) +
        ", multimedia=" + Arrays.toString(this.multimedia);
  }
}
