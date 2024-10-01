package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

  public static final String DELIMITER = ",|:";

  public static int splitAndSum(String text) {
    if (isBlank(text)) {
      return 0;
    }
    return sum(toInts(split(text)));
  }

  private static String[] split(String text) {
    Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (m.find()) {
      String customDelimiter = m.group(1);
      return m.group(2).split(customDelimiter);
    }
    return text.split(DELIMITER);
  }

  private static boolean isBlank(String text) {
    return text == null || text.isBlank();
  }

  private static int[] toInts(String[] values) {
    int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = Integer.parseInt(values[i]);
    }
    return numbers;
  }

  private static int sum(int[] numbers) {
    int result = 0;
    for (int number : numbers) {
      result += number;
    }
    return result;
  }
}
