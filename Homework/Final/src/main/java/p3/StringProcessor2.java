package p3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor2 {

  public StringProcessor2() {
  }

  public static List<Info> replaceAndRepeatLetters(char sourceChar, char destChar,
                                           int numRepetitions, List<String> stringList){
    List<Info> resultList = new ArrayList<>();
    Pattern pattern = Pattern.compile(String.valueOf(sourceChar), Pattern.CASE_INSENSITIVE);

    for (String s : stringList) {
      Integer count = 0;
      String refactored = null;
      Matcher m = pattern.matcher(s);
      while (m.find()) {
        count++;
      }

      if (count > 0) {
        refactored = m.replaceAll(buildString(destChar, numRepetitions));
      }

      Info item = new Info(s, refactored, count);
      resultList.add(item);
    }

    return resultList;
  }

  private static String buildString(char destChar, int numRepetitions) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < numRepetitions; i++) {
      builder.append(destChar);
    }
    return builder.toString();
  }
}