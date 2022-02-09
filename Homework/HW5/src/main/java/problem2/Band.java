package problem2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a band. Band is the subclass of Group
 */
public class Band extends Group {

  private String name;
  private Set<RecordingArtist> members;

  /**
   * Constructor for the Band class. This constructor version creates a new Band object
   * with no members.
   * @param name The name of the band
   */
  public Band(String name) {
    this.name = name;
    this.members = new HashSet<>();
  }

  /**
   * Constructor for the Band class. This constructor version creates a new Band object
   * with specifying the band members
   * @param name The name of the band
   * @param members The members of the band
   */
  public Band(String name, Set<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * Adds a new artist as the band member to the band.
   * @param artist The artist to add
   */
  public void addMember(RecordingArtist artist) {
    this.members.add(artist);
  }

  /**
   * Removes an specified artist from the band members
   * @param artist The artist to remove
   * @throws InvalidRemovalException if the artist to remove does not exist among the band members
   */
  public void removeMember(RecordingArtist artist) throws InvalidRemovalException {
    if (!this.members.remove(artist)) {
      throw new InvalidRemovalException("The member to remove does not exist!");
    }
  }

  /**
   * Checks if the particular person is the exact match for the creator. As for a band, the exact
   * match means the particular person is one of the band members.
   * @param person The person to check
   * @return true if the person to check is the exact match for the creator, false otherwise
   */
  @Override
  public boolean isExactMatch(Creator person) {
    return this.members.contains(person);
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
    Band band = (Band) o;
    return this.name.equals(band.name) && Objects.equals(this.members, band.members);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.members);
  }

  /**
   * Creates a string representation of the Band.
   * @return a string representation of the Band.
   */
  @Override
  public String toString() {
    return "Band{" +
        "name='" + this.name + '\'' +
        ", members=" + this.members +
        '}';
  }
}
