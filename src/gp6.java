import java.util.ArrayList;
import java.util.List;

/**
 * N字型变换
 * <p>
 * 实现利用了一个布尔变量goingDown来表示当前遍历的方向，从而确定每个字符在List<StringBuilder>中的位置
 */
public class gp6 {
  public String convert(String s, int numRows) {

    if (numRows >= s.length() || numRows == 1) {
      return s;
    }

    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      rows.add(new StringBuilder());
    }

    int currentRow = 0;
    boolean isGoingDown = false;

    for (char c : s.toCharArray()) {

      rows.get(currentRow).append(c);

      if (currentRow == 0 || currentRow == numRows - 1) {
        isGoingDown = !isGoingDown;
      }

      currentRow += isGoingDown ? 1 : -1;
    }

    StringBuilder result = new StringBuilder();
    for (StringBuilder row : rows) {
      result.append(row);
    }
    return result.toString();
  }
}
