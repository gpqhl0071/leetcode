/**
 * 整数反转
 */
public class gp7 {
  public int reverse(int x) {

    int sign = x > 0 ? 1 : -1;

    x = Math.abs(x);

    int result = 0; // 结果

    while (x > 0) {

      int tail = x % 10; // 得到x 的余数，也就是最后一个数字

      if (sign == 1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tail > 7))) {
        return 0;
      }
      if (sign == -1 && (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && tail > 8))) {
        return 0;
      }

      result = result * 10 + tail;

      x = x / 10;
    }

    return result * sign;
  }

  public static void main(String[] args) {
    gp7 g = new gp7();
    System.out.println(g.reverse(123));
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
  }

}
