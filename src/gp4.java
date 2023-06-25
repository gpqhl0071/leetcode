import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gp4 {
  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2}));

  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<Integer>();

    for (int num : nums1) {
      list.add(num);
    }

    for (int num : nums2) {
      list.add(num);
    }

    Collections.sort(list);

    int size = list.size();

    boolean isJi = size % 2 != 0;

    int targetIndex = isJi ? size / 2 : size / 2 - 1;

    double sum = 0;
    int currentIndex = 0;
    for (Integer value : list) {
      if (isJi) {
        if (targetIndex == currentIndex) {
          return value;
        }
      } else {
        if (targetIndex == currentIndex) {
          sum += value;
        } else if (targetIndex + 1 == currentIndex) {
          sum += value;
          return sum / 2;
        }
      }
      currentIndex++;
    }
    return 0;
  }
}
