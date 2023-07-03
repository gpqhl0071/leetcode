import java.util.HashMap;
import java.util.Map;

public class gp13 {
  Map<String, Integer> ROMAN_TO_ARABIC = new HashMap<>();

  public int romanToInt(String s) {

    ROMAN_TO_ARABIC.put("I", 1);
    ROMAN_TO_ARABIC.put("V", 5);
    ROMAN_TO_ARABIC.put("X", 10);
    ROMAN_TO_ARABIC.put("L", 50);
    ROMAN_TO_ARABIC.put("C", 100);
    ROMAN_TO_ARABIC.put("D", 500);
    ROMAN_TO_ARABIC.put("M", 1000);

    ROMAN_TO_ARABIC.put("CM", 900);
    ROMAN_TO_ARABIC.put("CD", 400);
    ROMAN_TO_ARABIC.put("XC", 90);
    ROMAN_TO_ARABIC.put("XL", 40);
    ROMAN_TO_ARABIC.put("IX", 9);
    ROMAN_TO_ARABIC.put("IV", 4);

    int result = 0;
    int i = 0;

    while (i < s.length()) {
      String currentSymbol = String.valueOf(s.charAt(i));

      if (i < s.length() - 1) {
        String nextSymbol = String.valueOf(s.charAt(i + 1));
        if (ROMAN_TO_ARABIC.containsKey(currentSymbol + nextSymbol)) {
          result += ROMAN_TO_ARABIC.get(currentSymbol + nextSymbol);
          i += 2;
          continue;
        }
      }

      result += ROMAN_TO_ARABIC.get(currentSymbol);
      i++;
    }

    return result;
  }
}

