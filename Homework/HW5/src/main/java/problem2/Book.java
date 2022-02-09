package problem2;

/**
 * Represents a book. Book is the subclass of the AbstractItem
 */
public class Book extends AbstractItem {

  /**
   * Constructor for the Book class.
   * @param author The author of the book
   * @param title The title of the book
   * @param year The year the book was published
   */
  public Book(Author author, String title, int year) {
    super(author, title, year);
  }

  /**
   * Creates a string representation of the Book.
   * @return a string representation of the Book.
   */
  @Override
  public String toString() {
    return "Book{" +
        "creator=" + this.getCreator() +
        ", title='" + this.getTitle() + '\'' +
        ", year=" + this.getYear() +
        '}';
  }
}
