/**
 * 字符转换成整型
 */
public class gp8 {
  public int myAtoi(String s) {
    int index = 0;
    int sign = 1;
    int result = 0;

    // Skip leading whitespaces
    while (index < s.length() && s.charAt(index) == ' ') {
      index++;
    }

    // Check sign
    if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')) {
      sign = (s.charAt(index++) == '-') ? -1 : 1;
    }

    // Process digits
    while (index < s.length() && Character.isDigit(s.charAt(index))) {
      int digit = s.charAt(index++) - '0';

      // Check for integer overflow/underflow
      if (result > (Integer.MAX_VALUE - digit) / 10) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      result = result * 10 + digit;
    }

    return result * sign;
  }

  public static void main(String[] args) {
    gp8 gp = new gp8();
    System.out.println(gp.myAtoi("-42"));
  }
}