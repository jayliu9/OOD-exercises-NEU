package problem1;

/**
 * Represents an actor. Actor is the subclass of Performer.
 */
public class Actor extends Performer {

  /**
   * Constructor for the Actor class
   * @param name The name of the actor
   * @param age The age of the actor
   * @param genres The actor's genres
   * @param award The actor's awards
   * @param movies All movies the actor acted in
   * @param series All TV series the actor acted in
   * @param multimedia All multimedia the actor acted in
   */
  public Actor(Name name, Integer age, String[] genres, String[] award, String[] movies,
      String[] series, String[] multimedia) {
    super(name, age, genres, award, movies, series, multimedia);
  }

  /**
   * Creates a string representation of the Actor.
   * @return a string representation of the Actor.
   */
  @Override
  public String toString() {
    return "Actor: " + super.toString();
  }
}
