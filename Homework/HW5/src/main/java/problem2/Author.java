package problem2;

/**
 * Represents an author. Author is the subclass of IndividualPerson
 */
public class Author extends IndividualPerson {

  /**
   * Constructor for the Author class
   * @param firstName The first name of the author
   * @param lastName The last name of the author
   */
  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  /**
   * Creates a string representation of the Author.
   * @return a string representation of the Author.
   */
  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + this.getFirstName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}
