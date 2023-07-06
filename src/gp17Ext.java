import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gp17Ext {
  // 创建一个映射，将数字与对应的字母进行关联
  private Map<Character, String> phoneMap = new HashMap<Character, String>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
  }};

  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    // 如果输入为空，直接返回空结果
    if (digits == null || digits.length() == 0) {
      return result;
    }
    // 使用回溯算法求解
    backtrack(result, new StringBuilder(), digits, 0);
    return result;
  }

  /**
   * 回溯算法
   *
   * @param result      结果列表
   * @param combination 当前组合
   * @param digits      输入的数字字符串
   * @param index       当前处理的数字字符的索引
   */
  private void backtrack(List<String> result, StringBuilder combination, String digits, int index) {
    // 如果当前处理的数字字符索引等于输入字符串长度，说明已经处理完所有字符，将当前组合添加到结果列表
    if (index == digits.length()) {
      result.add(combination.toString());
      return;
    }
    // 获取当前处理的数字字符
    char digit = digits.charAt(index);
    // 从映射中获取该数字对应的字母字符串
    String letters = phoneMap.get(digit);
    // 遍历字母字符串，将每个字母添加到当前组合中，并递归地处理下一个数字字符
    for (int i = 0; i < letters.length(); i++) {
      // 添加当前字母到组合中
      combination.append(letters.charAt(i));
      // 递归地处理下一个数字字符
      backtrack(result, combination, digits, index + 1);
      // 回溯：撤销之前添加的字母，尝试下一个字母
      combination.deleteCharAt(combination.length() - 1);
    }
  }

  public static void main(String[] args) {
    gp17Ext gp = new gp17Ext();
    System.out.println(gp.letterCombinations("23"));
  }
}
