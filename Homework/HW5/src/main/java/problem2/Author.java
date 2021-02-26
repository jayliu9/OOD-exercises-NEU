package problem2;

public class Author extends IndividualPerson {

  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + this.getFirstName() + '\'' +
        ", lastName='" + this.getLastName() + '\'' +
        '}';
  }
}
