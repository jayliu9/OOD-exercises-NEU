package problem2;


import java.util.Objects;

public abstract class AbstractItem implements Item {

  private Creator creator;
  private String title;
  private int year;

  public AbstractItem(Creator creator, String title, int year) {
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  @Override
  public boolean hasKeyword(String keyword) {
    return this.title.toLowerCase().contains(keyword.toLowerCase());
  }

  @Override
  public boolean hasCreator(Creator person) {
    return this.creator.isExactMatch(person);
  }

  public Creator getCreator() {
    return this.creator;
  }

  public String getTitle() {
    return this.title;
  }

  public int getYear() {
    return this.year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractItem that = (AbstractItem) o;
    return this.year == that.year && this.creator.equals(that.creator) &&
        this.title.equals(that.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.title, this.year);
  }
}
