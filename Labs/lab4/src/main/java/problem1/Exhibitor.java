package problem1;

import java.util.Arrays;

/**
 * Represents an exhibitor. Exhibitor is the subclass of AbstractArtist.
 */
public class Exhibitor extends AbstractArtist {

  private String[] exhibits;

  /**
   * Constructor for the Exhibitor class
   * @param name The name of the exhibitor
   * @param age The age of the exhibitor
   * @param genres The exhibitor's genres
   * @param award The exhibitor's awards
   * @param exhibits The exhibits where the exhibitor's art was shown
   */
  public Exhibitor(Name name, Integer age, String[] genres, String[] award,
      String[] exhibits) {
    super(name, age, genres, award);
    this.exhibits = exhibits;
  }

  /**
   * Gets the exhibits where the exhibitor's art was shown
   * @return The exhibits where the exhibitor's art was shown
   */
  public String[] getExhibits() {
    return this.exhibits;
  }

  /**
   * Adds an received award to their current array of awards.
   * @param award The received award
   * @return A new Exhibitor object with new array of awards.
   */
  @Override
  public Exhibitor receiveAward(String award) {
    int sourceListLength = this.getAward().length;
    String[] newList = new String[sourceListLength + 1];
    System.arraycopy(this.getAward(), 0, newList, 0, sourceListLength);
    newList[sourceListLength] = award;
    return new Exhibitor(this.getName(), this.getAge(), this.getGenres(), newList,
        this.exhibits);
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
    Exhibitor exhibitor = (Exhibitor) o;
    return Arrays.equals(this.exhibits, exhibitor.exhibits);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(this.exhibits);
    return result;
  }

  /**
   * Creates a string representation of the Exhibitor.
   * @return a string representation of the Exhibitor.
   */
  @Override
  public String toString() {
    return super.toString() + ", exhibits=" + Arrays.toString(this.exhibits);
  }
}
