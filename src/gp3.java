import java.util.HashSet;

public class gp3 {
  public int lengthOfLongestSubstring(String s) {
    int left = 0;
    int maxLength = 0;
    HashSet<Character> hs = new HashSet();

    for (int right = 0; right < s.length(); right++) {

      if (!hs.contains(s.charAt(right))) {
        hs.add(s.charAt(right));
        if (hs.size() > maxLength) maxLength = hs.size();
      } else {
        while (hs.contains(s.charAt(right))) {
          hs.remove(s.charAt(left));
          left++;
        }
        hs.add(s.charAt(right));
      }

    }

    return maxLength;
  }
}
