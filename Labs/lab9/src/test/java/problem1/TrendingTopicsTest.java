package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class TrendingTopicsTest {

  TrendingTopics trendingTopics;
  List<String> testList;

  @Before
  public void setUp() throws Exception {
    testList = Arrays.asList("Seattle", "wildfires", "DEFCON26", "NEU", "NEU", "Seattle", "Seattle",
        "NEU", "DEFCON26", "wildfires");
    trendingTopics = new TrendingTopics();
  }

  @Test
  public void countTopics() {
    Map<String, Long> expectedMap = new HashMap<>();
    expectedMap.put("Seattle", 3l);
    expectedMap.put("wildfires", 2l);
    expectedMap.put("DEFCON26", 2l);
    expectedMap.put("NEU", 3l);
    assertEquals(expectedMap, trendingTopics.countTopics(testList));
  }
}