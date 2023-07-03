/**
 * I             1 V             5 X             10 L             50 C             100 D 500 M 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class gp12 {
  public String intToRoman(int num) {

    Integer a = num;
    StringBuilder result = new StringBuilder();

    String sign = "M";
    int temp = 1000;

    a = h(a, result, "M", 1000);
    a = h(a, result, "D", 500);
    a = h(a, result, "C", 100);
    a = h(a, result, "L", 50);
    a = h(a, result, "X", 10);
    a = h(a, result, "V", 5);
    a = h(a, result, "I", 1);

    return result.toString();
  }

  private static int h(Integer a, StringBuilder result, String sign, int temp) {
    if (a < temp) {
      return a;
    }

    if (a / 100 == 9) {
      result.append("CM");
      a -= 900;
      return a;
    } else if (a / 100 == 4) {
      result.append("CD");
      a -= 400;
      return a;
    } else if (a / 10 == 9) {
      result.append("XC");
      a -= 90;
      return a;
    } else if (a / 10 == 4) {
      result.append("XL");
      a -= 40;
      return a;
    } else if (a / 1 == 4) {
      result.append("IV");
      a -= 4;
      return a;
    } else if (a / 1 == 9) {
      result.append("IX");
      a -= 9;
      return a;
    }

    int m = a / temp;
    if (m > 0) {
      for (int i = 0; i < m; i++) {
        result.append(sign);
      }
    }
    a -= temp * m;

    return a;
  }

  public static void main(String[] args) {
    gp12 gp = new gp12();
    System.out.println(gp.intToRoman(20));
  }
}
