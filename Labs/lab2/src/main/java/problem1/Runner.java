package problem1;

/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5005
 * Course Number: 38135
 * Semester: Spring 2021
 *
 * This class represents a runner. Runner is a subclass of Athlete. A Runner also has the best time
 * in 5 kilometers, the best half-marathon time and the favorite running event.
 *
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double halfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Constructs a new Runner object, based upon all of the provided input parameters.
   * @param athletesName The Runner's Name, containing Runner's first, middle and last name
   * @param height The Runner's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight The Runner's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param league The Runner's league, expressed as String
   * @param best5KTime The Runner's best time in 5 kilometers
   * @param halfMarathonTime The Runner's best time in half marathon
   * @param favoriteRunningEvent The Runner's favorite running event.
   */
  public Runner(Name athletesName, Double height, Double weight, String league,
      Double best5KTime, Double halfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.halfMarathonTime = halfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructs a new Runner object, based upon all of the provided input parameters.
   * @param athletesName The Runner's Name, containing Runner's first, middle and last name
   * @param height The Runner's height, expressed as a Double in cm (e.g., 6'2'' is recorded as 187.96cm)
   * @param weight The Runner's weigh, expressed as a Double in pounds (e.g. 125, 155, 200 pounds)
   * @param best5KTime The Runner's best time in 5 kilometers
   * @param halfMarathonTime The Runner's best time in half marathon
   * @param favoriteRunningEvent The Runner's favorite running event.
   */
  public Runner(Name athletesName, Double height, Double weight, Double best5KTime,
      Double halfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight);
    this.best5KTime = best5KTime;
    this.halfMarathonTime = halfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Returns the Runner's best time in 5 kilometers as a Double
   * @return the Runner's best time in 5 kilometers
   */
  public Double getBest5KTime() {
    return this.best5KTime;
  }

  /**
   * Sets the Runner's best time in 5 kilometers
   * @param best5KTime The new best time in 5 kilometers
   */
  public void setBest5KTime(Double best5KTime) {
    this.best5KTime = best5KTime;
  }

  /**
   * Returns the Runner's best half-marathon time as a Double
   * @return the Runner's best time in 5 kilometers
   */
  public Double getHalfMarathonTime() {
    return this.halfMarathonTime;
  }

  /**
   * Sets the Runner's best time in 5 half marathon
   * @param halfMarathonTime The new best time in half marathon
   */
  public void setHalfMarathonTime(Double halfMarathonTime) {
    this.halfMarathonTime = halfMarathonTime;
  }

  /**
   * Returns the Runner's favorite running event as a String
   * @return the Runner's favorite running event
   */
  public String getFavoriteRunningEvent() {
    return this.favoriteRunningEvent;
  }

  /**
   * Sets the Runner's favorite running event
   * @param favoriteRunningEvent The new favorite running event
   */
  public void setFavoriteRunningEvent(String favoriteRunningEvent) {
    this.favoriteRunningEvent = favoriteRunningEvent;
  }
}
