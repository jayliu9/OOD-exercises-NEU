package problem2;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Band extends Group {

  private String name;
  private List<RecordingArtist> members;

  public Band(String name) {
    this.name = name;
    this.members = new LinkedList<>();
  }

  public Band(String name, List<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  @Override
  public boolean isExactMatch(Creator person) {
    return this.members.contains(person);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(this.name, band.name) && Objects
        .equals(this.members, band.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.members);
  }

  @Override
  public String toString() {
    return "Band{" +
        "name='" + this.name + '\'' +
        ", members=" + this.members +
        '}';
  }
}
