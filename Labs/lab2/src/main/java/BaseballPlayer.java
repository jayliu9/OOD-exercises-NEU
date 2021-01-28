/**
 * Name: Shijie Liu
 * NUID: 001561546
 * Course: CS 5005
 * Course Number: 38135
 * Semester: Spring 2021
 *
 * This class represents a baseball player. BaseballPlayer is a subclass of Athlete. The baseball
 * player also has a team, an average batting and season home runs.
 */
public class BaseballPlayer extends Athlete {


  private String team;
  private Double averageBatting;
  private Integer seasonHomeRun;

  /**
   * Constructs a new Runner object, based upon all of the provided input parameters.
   * @param athletesName The baseball player's Name
   * @param height The baseball player's height
   * @param weight The baseball player's weigh
   * @param league The baseball player's league
   * @param team The baseball player's team
   * @param averageBatting The baseball player's average batting
   * @param seasonHomeRun The baseball player's season home runs
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String league,
      String team, Double averageBatting, Integer seasonHomeRun) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRun = seasonHomeRun;
  }

  /**
   * Constructs a new Runner object, based upon all of the provided input parameters.
   * @param athletesName The baseball player's Name
   * @param height The baseball player's height
   * @param weight The baseball player's weigh
   * @param team The baseball player's team
   * @param averageBatting The baseball player's average batting
   * @param seasonHomeRun The baseball player's season home runs
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight, String team,
      Double averageBatting, Integer seasonHomeRun) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRun = seasonHomeRun;
  }

  /**
   * Returns the baseball player's team
   * @return The baseball player's team
   */
  public String getTeam() {
    return this.team;
  }

  /**
   * Sets the baseball player's team
   * @param team The new team
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * Returns the baseball player's average batting
   * @return The baseball player's average batting
   */
  public Double getAverageBatting() {
    return this.averageBatting;
  }

  /**
   * Sets the baseball player's average batting
   * @param averageBatting The new average batting
   */
  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  /**
   * Returns the baseball player's season home runs
   * @return the baseball player's season home runs
   */
  public Integer getSeasonHomeRun() {
    return this.seasonHomeRun;
  }

  /**
   * Sets the baseball player's season home runs
   * @param seasonHomeRun The new season home runs
   */
  public void setSeasonHomeRun(Integer seasonHomeRun) {
    this.seasonHomeRun = seasonHomeRun;
  }
}
