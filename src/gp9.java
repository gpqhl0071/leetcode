/**
 * 判断给定的 x 是否为回文数
 * <p>
 * 例如，121 是回文，而 123 不是。
 */
public class gp9 {

  public boolean isPalindrome(int x) {

    if (x < 0) {
      return false;
    }

    int a = x;
    int result = 0;

    while (a > 0) {
      int b = a % 10;
      a = a / 10;

      result = result * 10 + b;
    }

    if (result == x) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    gp9 gp = new gp9();
    System.out.println(gp.isPalindrome(121));
  }
}
