package problem1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The class represents a non-profit.
 */
public class NonProfit {

  private String name;
  private Set<Donation> donations;

  /**
   * Constructor for the NonProfit class
   * @param name The name of the organization.
   */
  public NonProfit(String name) {
    this.name = name;
    this.donations = new HashSet<>();
  }

  /**
   * Receives a donation made to the non-profit.
   * @param donation The donation to receive
   */
  public void receive(Donation donation) {
    this.donations.add(donation);
  }

  /**
   * Removes a given donation
   * @param donation The donation to remove
   * @throws InvalidRemovalException if the donation to remove does not exist.
   */
  public void remove(Donation donation) throws InvalidRemovalException {
    if (!this.donations.remove(donation)) {
      throw new InvalidRemovalException();
    }
  }

  /**
   * Gets the sum of all donations processed in the specified year
   * @param year The specified year
   * @return The sum of all donations processed in the specified year
   */
  public long getTotalDonationsForYear(int year) {
    long sumOfDonations = 0;
    for (Donation item : this.donations) {
      sumOfDonations += item.getAmountForYear(year);
    }
    return sumOfDonations;
  }

  /**
   * Gets the name of the organization.
   * @return The name of the organization.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets all the donations made to the non-profit.
   * @return All the donations made to the non-profit.
   */
  public Set<Donation> getDonations() {
    return this.donations;
  }

  /**
   * Checks if two objects are equal
   * @param o the object to compare this to
   * @return true if these two objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(this.name, nonProfit.name) && Objects
        .equals(this.donations, nonProfit.donations);
  }

  /**
   * Gets a hash code value for the object.
   * @return a hash code value for the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.donations);
  }

  /**
   * Creates a string representation of the NonProfit.
   * @return a string representation of the NonProfit.
   */
  @Override
  public String toString() {
    return "NonProfit{" +
        "name='" + this.name + '\'' +
        ", donations=" + this.donations +
        '}';
  }
}
