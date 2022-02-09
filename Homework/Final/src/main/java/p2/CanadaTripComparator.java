package p2;

import java.util.Comparator;

public class CanadaTripComparator implements Comparator<Traveler> {

  /**
   * Compares travelers based on the number of times they traveled to Canada over last three years
   * @param t1 The traveler to compare
   * @param t2 The other traveler to compare
   * @return a negative integer, zero, or a positive integer as the first argument
   * is less than, equal to, or greater than the second.
   */
  @Override
  public int compare(Traveler t1, Traveler t2) {
    return Integer.compare(this.findNumOfTripToCanada(t1), this.findNumOfTripToCanada(t2));
  }

  /**
   * Helper method to find the number of trips a traveler took to Canada over the last three
   * years
   * @param t A traveler object
   * @return The number of trips the traveler took to Canada over the last three years
   */
  private Integer findNumOfTripToCanada(Traveler t) {
    Integer count = 0;
    for (Destination destination : t.traveledDestinations()) {
      if (destination.getCountry().equals("Canada")) {
        count += 1;
      }
    }
    return count;
  }
}

