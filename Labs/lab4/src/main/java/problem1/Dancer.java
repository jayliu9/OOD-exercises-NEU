package problem1;

/**
 * Represents a dancer. Dancer is the subclass of Performer.
 */
public class Dancer extends Performer {

  /**
   * Constructor for the Dancer class
   * @param name The name of the dancer
   * @param age The age of the dancer
   * @param genres The dancer's genres
   * @param award The dancer's awards
   * @param movies All movies the dancer worked on
   * @param series All TV series the dancer worked on
   * @param multimedia All multimedia the dancer worked on
   */
  public Dancer(Name name, Integer age, String[] genres, String[] award, String[] movies,
      String[] series, String[] multimedia) {
    super(name, age, genres, award, movies, series, multimedia);
  }

  /**
   * Creates a string representation of the Dancer.
   * @return a string representation of the Dancer.
   */
  @Override
  public String toString() {
    return "Dancer: " + super.toString();
  }
}
