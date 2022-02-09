package problem2;


import java.util.Objects;

/**
 * Abstract class representing common fields and behaviors of an item in the library.
 */
public abstract class AbstractItem implements Item {

  private Creator creator;
  private String title;
  private int year;

  /**
   * Constructor for the AbstractItem
   * @param creator The creator of the item
   * @param title The title of the item
   * @param year The year the item was released or published.
   */
  protected AbstractItem(Creator creator, String title, int year) {
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  /**
   * Checks if the title of the item has the given keyword, which is case insensitive.
   * @param keyword The keyword to check
   * @return true if the item has the given keyword, false otherwise.
   */
  @Override
  public boolean hasKeyword(String keyword) {
    return this.title.toLowerCase().contains(keyword.toLowerCase());
  }

  /**
   * Checks if the item has the exact match for the specified person
   * @param person The person to check
   * @return true if the item has the exact match for the specified person, false otherwise.
   */
  @Override
  public boolean hasCreator(Creator person) {
    return this.creator.isExactMatch(person);
  }

  /**
   * Gets the creator of the item
   * @return The creator of the item
   */
  public Creator getCreator() {
    return this.creator;
  }

  /**
   * Gets the title of the item
   * @return The title of the item
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Gets the year the item was released or published.
   * @return The year the item was released or published.
   */
  public int getYear() {
    return this.year;
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
    AbstractItem that = (AbstractItem) o;
    return this.year == that.year && this.creator.equals(that.creator) &&
        this.title.equals(that.title);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.title, this.year);
  }
}
