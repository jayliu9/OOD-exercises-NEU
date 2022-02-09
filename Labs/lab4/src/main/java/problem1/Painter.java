package problem1;

/**
 * Represents a painter. Painter is the subclass of Exhibitor.
 */
public class Painter extends Exhibitor {

  /**
   * Constructor for the Painter class
   * @param name The name of the painter
   * @param age The age of the painter
   * @param genres The painter's genres
   * @param award The painter's awards
   * @param exhibits The exhibits where the painter's art was shown
   */
  public Painter(Name name, Integer age, String[] genres, String[] award,
      String[] exhibits) {
    super(name, age, genres, award, exhibits);
  }

  /**
   * Creates a string representation of the Painter.
   * @return a string representation of the Painter.
   */
  @Override
  public String toString() {
    return "Painter: " + super.toString();
  }
}
