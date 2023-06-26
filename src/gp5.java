public class gp5 {


  /**
   * abba 最长回文子串  a bb a
   * <p>
   * aba 最长回文子串 a b a
   * <p>
   * abccba 最长回文子串 a b cc b a
   * <p>
   * 有两种情况，一种是中间是一个字母两遍想同，一种是中间是两个字母两百年想同，也就是中间数为奇偶数
   * <p>
   * <p>
   * 解题思路，
   * <p>
   * 1、遍历每个字符、前后指针+1，比较，判断是否相同
   * <p>
   * 2、区分中间字符是奇数 还是 偶数情况，比如 aba 和 abccba
   *
   * @param s
   * @return
   */
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }

    int maxLength = 1;
    int start = 0;

    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);

      int currMaxLength = Math.max(len1, len2);

      if (currMaxLength > maxLength) {
        maxLength = currMaxLength;
        start = i - (currMaxLength - 1) / 2;
      }
    }

    return s.substring(start, start + maxLength);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while (right < s.length() && left >= 0 && s.charAt(right) == s.charAt(left)) {
      left--; // 左移
      right++; // 右移
    }

    // 考虑到最后一次循 left right 都多移动了一次，所以要减2，由于计算长度，所以从0开始，所以下面代码减1就可以。
    return right - left - 1;
  }

  public static void main(String[] args) {
    gp5 gp5 = new gp5();
    System.out.println(gp5.longestPalindrome("bb"));

  }
}
