import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gp18 {

  /**
   * nums[a] + nums[b] + nums[c] + nums[d] == target
   *
   * @param nums
   * @param target
   * @return
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> resultList = new ArrayList<>();

    if (nums == null || nums.length < 4) {
      return resultList;
    }

    Arrays.sort(nums);
    int n = nums.length;

    for (int i = 0; i < n - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
        // 前4个小数相加，比目标值大，则列表中午满足条件的数据，直接跳出，返回
        break;
      }
      if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
        // 第一个元素，和最大的3个元素加和小于目标值，则直接跳过第i个元素，遍历下一个值
        continue;
      }

      for (int j = i + 1; j < n - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
          break;
        }
        if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
          continue;
        }

        int left = j + 1;
        int right = n - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            while (left < right && nums[left] == nums[left + 1]) {
              left++;
            }
            left++;
            while (left < right && nums[right] == nums[right - 1]) {
              right--;
            }
            right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    gp18 gp = new gp18();
    System.out.println(gp.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
  }
}
