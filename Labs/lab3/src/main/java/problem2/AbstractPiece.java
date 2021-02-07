package problem2;

import java.util.Objects;

public abstract class AbstractPiece implements Piece {

  private Name name;
  private Integer age;
  private static final Integer MAX = 128;

  public AbstractPiece(Name name, Integer age) throws InvalidAgeException {
    this.name = name;
    this.validateAge(age);
    this.age = age;
  }

  private void validateAge(Integer age) throws InvalidAgeException {
    if (age < 0 || age > MAX) {
      throw new InvalidAgeException();
    }
  }

  public Name getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.age);
  }
}
