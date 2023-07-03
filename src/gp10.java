/**
 * Input: s = "mississippi", p = "mis*is*p*."
 * <p>
 * 动态规划
 */
public class gp10 {
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;

    for (int j = 1; j <= p.length(); j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 2];
      }
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 2];
          if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
            dp[i][j] = dp[i][j] || dp[i - 1][j];
          }
        }
      }
    }

    return dp[s.length()][p.length()];
  }

  public static void main(String[] args) {
    gp10 gp = new gp10();

    // Input: s = "mississippi", p = "mis*is*p*."
    System.out.println(gp.isMatch("ab", "ab*"));
  }

}
