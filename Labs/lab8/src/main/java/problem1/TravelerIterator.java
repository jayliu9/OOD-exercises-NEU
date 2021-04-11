package problem1;

import java.util.Iterator;
import java.util.List;

public class TravelerIterator implements Iterator<Traveler> {

  private List<Traveler> list;
  private int current;

  public TravelerIterator(List<Traveler> list) {
    this.list = list;
    this.current = 0;
    this.updateCurrent();
  }

  @Override
  public boolean hasNext() {
    return this.current < list.size();
  }

  @Override
  public Traveler next() {
    Traveler traveler = list.get(this.current);
    this.current++;
    this.updateCurrent();
    return traveler;
  }

  private boolean areDomestic(List<Destination> list) {
    for (Destination d : list) {
      if (d.getCountry() != "US")
        return false;
    }
    return true;
  }

  private void updateCurrent() {
    while (this.hasNext() && !this.areDomestic(this.list.get(this.current).traveledDestinations())) {
      this.current++;
    }
  }
}
