package p3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RestaurantRecommender {

  private static final Integer START_VALUE = 1;
  private Map<Restaurant, Integer> restaurantStatistics;

  public RestaurantRecommender() {
    this.restaurantStatistics = new HashMap<>();
  }

  public Map<Restaurant, Integer> getAggregatedStatistics(List<Guest> guests) {
    Map<Restaurant, Integer> resultingMap = new HashMap<>();

    for(Guest guest : guests) {
      for (Restaurant restaurant : guest.getVisitedRestaurant()) {
        if(!resultingMap.containsKey(restaurant)) {
          resultingMap.put(restaurant, START_VALUE);
        } else {
          resultingMap.put(restaurant, resultingMap.get(restaurant) + START_VALUE);
        }
      }
    }
    this.restaurantStatistics = resultingMap;
    return resultingMap;
  }

  public Restaurant recommendMostVisitedRestaurant() {
    Restaurant mostVisited = null;
    Integer numOfVisits = Integer.MIN_VALUE;

    for (Map.Entry<Restaurant, Integer> entry : this.restaurantStatistics.entrySet()) {
      if (entry.getValue() > numOfVisits) {
        mostVisited = entry.getKey();
        numOfVisits = entry.getValue();
      }
    }
    return mostVisited;
  }

  public Restaurant recommendHighlyRatedRestaurant(String cuisine) {
    Set<Restaurant> filteredRestaurants = this.restaurantStatistics.keySet().stream()
        .filter(r -> r.getCuisine().equals(cuisine))
        .collect(Collectors.toSet());

    Restaurant highlyRated = null;
    Float rating = Float.MIN_VALUE;
    for (Restaurant r : filteredRestaurants) {
      if (r.getRating() > rating) {
        highlyRated = r;
        rating = r.getRating();
      }
    }
    return highlyRated;
  }
}
