package problem2;

import java.util.Objects;

/**
 * Abstract class representing common fields and behaviors of a Piece.
 */
public abstract class AbstractPiece implements Piece {

  private Name name;
  private Integer age;
  private static final Integer MAX = 128;

  /**
   * Constructor for the AbstractPiece class
   * @param name The name of the piece.
   * @param age The age of the piece
   * @throws InvalidAgeException if the age is invalid
   */
  public AbstractPiece(Name name, Integer age) throws InvalidAgeException {
    this.name = name;
    this.validateAge(age);
    this.age = age;
  }

  /**
   * Checks that the age is valid
   * @param age The age to check
   * @throws InvalidAgeException if the age is invalid
   */
  private void validateAge(Integer age) throws InvalidAgeException {
    if (age < 0 || age > MAX) {
      throw new InvalidAgeException();
    }
  }

  /**
   * Gets the name of the piece
   * @return The name of the piece
   */
  public Name getName() {
    return this.name;
  }

  /**
   * Gets the age of the piece
   * @return The age of the piece
   */
  public Integer getAge() {
    return this.age;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractPiece that = (AbstractPiece) o;
    return this.name.equals(that.name) && this.age.equals(that.age);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age);
  }
}
