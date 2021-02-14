package problem1;

/**
 * Represents a filmmaker. Filmmaker is the subclass of Performer.
 */
public class Filmmaker extends Performer {

  /**
   * Constructor for the Filmmaker class
   * @param name The name of the filmmaker
   * @param age The age of the filmmaker
   * @param genres The filmmaker's genres
   * @param award The filmmaker's awards
   * @param movies All movies the filmmaker worked on
   * @param series All TV series the filmmaker worked on
   * @param multimedia All multimedia the filmmaker worked on
   */
  public Filmmaker(Name name, Integer age, String[] genres, String[] award, String[] movies,
      String[] series, String[] multimedia) {
    super(name, age, genres, award, movies, series, multimedia);
  }

  /**
   * Creates a string representation of the Filmmaker.
   * @return a string representation of the Filmmaker.
   */
  @Override
  public String toString() {
    return "Filmmaker: " + super.toString();
  }
}
