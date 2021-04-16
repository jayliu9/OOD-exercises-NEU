package problem1;

import java.util.List;
import java.util.Objects;

/**
 * Class represents a traveler. The traveler has a first name, last name and a
 * list of destinations they visited in the last year.
 */
public class Traveler implements Comparable<Traveler> {
  private String firstName;
  private String lastName;
  private List<Destination> traveledDestinations;

  /**
   * Constructs a Traveler object and initializes it
   * to the given first name, last name and the list of traveled destinations
   * @param firstName the first name of this person
   * @param lastName the last name of this person
   * @param traveledDestinations list of destinations they visited in the last year.
   */

  public Traveler(String firstName, String lastName, List<Destination> traveledDestinations) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.traveledDestinations = traveledDestinations;
  }

  /**
   * Gets the first name of the traveler
   * @return The first name of the traveler
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name of the traveler
   * @return The last name of the traveler
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets the traveler's destinations
   * @return The list of the traveler's destinations
   */
  public List<Destination> traveledDestinations() {
    return traveledDestinations;
  }

  /**
   * Compares two objects
   * @param otherTraveler the object to compare
   * @return -1, 0, 1 as this object is less than, equal to or greater than the specified object.
   * using the first name as tie breaker.
   */
  @Override
  public int compareTo(Traveler otherTraveler) {
    if (this.equals(otherTraveler))
      return 0;
    if (this.traveledDestinations.size() > otherTraveler.traveledDestinations.size())
      return 1;
    if (this.traveledDestinations.size() < otherTraveler.traveledDestinations.size())
      return -1;
    return this.firstName.compareTo(otherTraveler.firstName);
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Traveler traveler = (Traveler) o;
    return firstName.equals(traveler.firstName) && lastName.equals(traveler.lastName) && traveledDestinations.equals(traveler.traveledDestinations);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, traveledDestinations);
  }
}