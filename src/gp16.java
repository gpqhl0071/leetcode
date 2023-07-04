import java.util.Arrays;

public class gp16 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums); // 首先对数组进行排序

    int min = Integer.MAX_VALUE; // 初始一个大值
    int minTarget = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;

      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right]; // 计算数组中三个数的合

        int diff = Math.abs(sum - target); // 计算和目标值相差多少
        if (diff < min) {
          // 获取差距最小的值
          min = diff;
          minTarget = sum;
        }

        // 这里需要正确的移动指针位置
        if (sum < target) {
          left++;
        } else if (sum > target) {
          right--;
        } else {
          return minTarget;
        }

      }
    }

    return minTarget;
  }

  public static void main(String[] args) {
    gp16 gp = new gp16();
    System.out.println(gp.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }
}
