package problem1;

import java.util.Iterator;
import java.util.List;

/**
 * Represents an iterator for Traveler
 */
public class TravelerIterator implements Iterator<Traveler> {

  private List<Traveler> list;
  private int current;

  /**
   * Constructor for the TravelerIterator class
   * @param list The list of travelers
   */
  public TravelerIterator(List<Traveler> list) {
    this.list = list;
    this.current = 0;
    this.updateCurrent();
  }

  /**
   * Checks if there is next element to iterate from the view of TravelerIterator
   * @return true if there is next element to iterate, false otherwise
   */
  @Override
  public boolean hasNext() {
    return this.current < list.size();
  }

  /**
   * Returns the Travel at the current index, step forward to the next index
   * @return The Travel at the current index
   */
  @Override
  public Traveler next() {
    Traveler traveler = list.get(this.current);
    this.current++;
    this.updateCurrent();
    return traveler;
  }

  /**
   * Checks if the traveler did not travel outside of the US during the last year
   * @param list The list of travel destination
   * @return true if the travel did not travel outside of the US during the last year, false otherwise
   */
  private boolean areDomestic(List<Destination> list) {
    for (Destination d : list) {
      if (d.getCountry() != "US")
        return false;
    }
    return true;
  }

  /**
   * Updates the current index to next index of the traveler who did not travel outside of the US
   * during the last year.
   */
  private void updateCurrent() {
    while (this.current < list.size() && !this.areDomestic(this.list.get(this.current).traveledDestinations())) {
      this.current++;
    }
  }
}
