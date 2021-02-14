package problem1;

/**
 * Represents a photographer. Photographer is the subclass of Exhibitor.
 */
public class Photographer extends Exhibitor {

  /**
   * Constructor for the Photographer class
   * @param name The name of the photographer
   * @param age The age of the photographer
   * @param genres The photographer's genres
   * @param award The photographer's awards
   * @param exhibits The exhibits where the photographer's art was shown
   */
  public Photographer(Name name, Integer age, String[] genres, String[] award,
      String[] exhibits) {
    super(name, age, genres, award, exhibits);
  }

  /**
   * Creates a string representation of the Photographer.
   * @return a string representation of the Photographer.
   */
  @Override
  public String toString() {
    return "Photographer: " + super.toString();
  }
}
