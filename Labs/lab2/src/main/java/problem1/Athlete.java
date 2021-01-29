package problem1;

/**
 * Class Athlete contains information about an athlete, including athlete's name, their height, weight and league.
 */
public class Athlete {

  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName The athlete's Name, containing athlete's first, middle and last name
   * @param height The athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight The athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league The athelete's league, expressed as String
   */
  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }

  /**
   * Constructs a new athlete, based upon all of the provided input parameters.
   * @param athletesName The object Name, containing athlete's first, middle and last name
   * @param height The athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight The athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   */
  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }

  /**
   * Returns athlete's name as an object Name
   * @return The Athlete's Name
   */
  public Name getAthletesName() {
    return athletesName;
  }

  /**
   * Returns athlete's height as a Double
   * @return The Athlete's height
   */
  public Double getHeight() {
    return height;
  }

  /**
   * Returns athlete's weight as a Double
   * @return The Athlete's weight
   */
  public Double getWeight() {
    return weight;
  }

  /**
   * Returns athlete's league as a String
   * @return The Athlete's league
   */
  public String getLeague() {
    return league;
  }
}

