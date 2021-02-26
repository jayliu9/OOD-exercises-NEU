package problem2;

public class Book extends AbstractItem {

  public Book(Author author, String title, int year) {
    super(author, title, year);
  }

  @Override
  public String toString() {
    return "Book{" +
        "creator=" + this.getCreator() +
        ", title='" + this.getTitle() + '\'' +
        ", year=" + this.getYear() +
        '}';
  }
}
