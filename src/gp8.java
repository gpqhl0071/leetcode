/**
 * 字符转换成整型
 */
public class gp8 {
  public int myAtoi(String s) {
    s = s.trim();

    if (s.equals("") || (s.length() == 1 && (s.equals("-") || s.equals("+")))) {
      return 0;
    }

    int sign = s.charAt(0) == '-' ? -1 : 1;
    if (s.charAt(0) == '-' || s.charAt(0) == '+') {
      s = s.substring(1);
    }

    StringBuilder result = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        result.append(c);
      } else {
        break;
      }
    }

    if (result.length() == 0) {
      return 0;
    }

    long num = 0;
    try {
      num = Long.parseLong(result.toString());
    } catch (NumberFormatException e) {
      return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }

    num *= sign;
    if (num > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (num < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int) num;
  }

  public static void main(String[] args) {
    gp8 gp = new gp8();
    System.out.println(gp.myAtoi("-42"));
  }
}