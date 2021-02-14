package problem1;

import java.util.Objects;

/**
 * Represents a poet. Poet is the subclass of AbstractArtist.
 */
public class Poet extends AbstractArtist {

  private String publishingCompany;
  private String lastPublishedCollection;

  /**
   * Constructor for the Poet class
   * @param name The name of the poet
   * @param age The age of the poet
   * @param genres The poet's genres
   * @param award The poet's awards
   * @param publishingCompany The poet's publishing company
   * @param lastPublishedCollection The title of the latest published collection of poems
   */
  public Poet(Name name, Integer age, String[] genres, String[] award,
      String publishingCompany, String lastPublishedCollection) {
    super(name, age, genres, award);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  /**
   * Adds an received award to their current array of awards.
   * @param award The received award
   * @return A new Poet object with new array of awards.
   */
  @Override
  public Poet receiveAward(String award) {
    int sourceListLength = this.getAward().length;
    String[] newList = new String[sourceListLength + 1];
    System.arraycopy(this.getAward(), 0, newList, 0, sourceListLength);
    newList[sourceListLength] = award;
    return new Poet(this.getName(), this.getAge(), this.getGenres(), newList,
        this.publishingCompany, this.lastPublishedCollection);
  }

  /**
   * Gets the poet's publishing company
   * @return The poet's publishing company
   */
  public String getPublishingCompany() {
    return this.publishingCompany;
  }

  /**
   * Gets the title of the latest published collection of poems
   * @return The title of the latest published collection of poems
   */
  public String getLastPublishedCollection() {
    return this.lastPublishedCollection;
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
    Poet poet = (Poet) o;
    return this.publishingCompany.equals(poet.publishingCompany) && this.lastPublishedCollection
        .equals(poet.lastPublishedCollection);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), this.publishingCompany, this.lastPublishedCollection);
  }

  /**
   * Creates a string representation of the Poet.
   * @return a string representation of the Poet.
   */
  @Override
  public String toString() {
    return "Poet: " + super.toString() +
        ", publishingCompany=" + this.publishingCompany +
        ", lastPublishedCollection=" + this.lastPublishedCollection;
  }
}
