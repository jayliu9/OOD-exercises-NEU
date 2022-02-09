package p2;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelerIterator implements Iterator<Traveler> {

  private static final Integer TRAVEL_TIMES_CUTOFF = 5;
  private List<Traveler> travelers;
  private int current;

  public TravelerIterator(List<Traveler> travelers) {
    this.travelers = this.filterByTimesOfTravels(travelers);
    this.current = 0;
  }

  private List<Traveler> filterByTimesOfTravels(List<Traveler> travelers) {
    return travelers.stream()
        .filter(t -> t.traveledDestinations().size() > TRAVEL_TIMES_CUTOFF)
        .collect(Collectors.toList());
  }

  @Override
  public boolean hasNext() {
    return this.current < this.travelers.size();
  }

  @Override
  public Traveler next() {
    Traveler t = this.travelers.get(this.current);
    this.current++;
    return t;
  }
}
