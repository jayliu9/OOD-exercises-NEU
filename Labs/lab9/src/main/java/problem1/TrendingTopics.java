package problem1;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents the counter of topics
 */
public class TrendingTopics {

  /**
   * Gets the number of occurrences of every String in the input list as a Map, where every distinct
   * String represents the Map key, and the number of the String’s occurrences the Map value.
   *
   * @param topicsList The list of Strings
   * @return The number of occurrences of every String in the input list as a Map
   */
  public Map<String, Long> countTopics(List<String> topicsList) {
    return topicsList.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }
}
