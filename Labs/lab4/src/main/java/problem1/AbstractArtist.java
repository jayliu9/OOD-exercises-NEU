package problem1;

import java.util.Arrays;
import java.util.Objects;

/**
 * Abstract class representing common fields and behaviors of an artist.
 */
public abstract class AbstractArtist implements Artist {

  private Name name;
  private Integer age;
  private String[] genres;
  private String[] award;

  /**
   * Constructor for the AbstractArtist class
   * @param name The name of the artist
   * @param age The age of the artist
   * @param genres The artist's genres
   * @param award The artist's awards
   */
  public AbstractArtist(Name name, Integer age, String[] genres, String[] award) {
    this.name = name;
    this.age = age;
    this.genres = genres;
    this.award = award;
  }

  /**
   * Gets the name of the artist
   * @return The name of the artist
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Gets the age of the artist
   * @return The age of the artist
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * Gets the artist's genres
   * @return The artist's genres
   */
  public String[] getGenres() {
    return this.genres;
  }

  /**
   * Gets the artist's awards
   * @return The artist's awards.
   */
  public String[] getAward() {
    return this.award;
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
    AbstractArtist that = (AbstractArtist) o;
    return this.name.equals(that.name) && this.age.equals(that.age) && Arrays
        .equals(this.genres, that.genres) && Arrays.equals(this.award, that.award);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(this.name, this.age);
    result = 31 * result + Arrays.hashCode(this.genres);
    result = 31 * result + Arrays.hashCode(this.award);
    return result;
  }

  /**
   * Creates a string representation of the AbstractArtist.
   * @return a string representation of the AbstractArtist.
   */
  @Override
  public String toString() {
    return "name=" + this.name +
        ", age=" + this.age +
        ", genres=" + Arrays.toString(this.genres) +
        ", award=" + Arrays.toString(this.award);
  }
}
