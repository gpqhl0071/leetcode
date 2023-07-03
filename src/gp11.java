/**
 * "盛最多水的容器"
 */
public class gp11 {
  public int maxArea(int[] height) {

    int left = 0;
    int right = height.length - 1;
    int max = 0;

    while (left < right) {
      int current = Math.min(height[right], height[left]) * (right - left);

      max = Math.max(max, current);

      // 保留最高的那根柱子
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    gp11 gp = new gp11();
    int[] i = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(gp.maxArea(i));
  }
}
