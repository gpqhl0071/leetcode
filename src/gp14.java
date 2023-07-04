/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 */
public class gp14 {

  public String longestCommonPrefix(String[] strs) {

    String prefixStr = strs[0];

    for (int i = 0; i < strs.length; i++) {
      while (strs[i].indexOf(prefixStr) != 0) {
        prefixStr = prefixStr.substring(0, prefixStr.length() - 1);
        if (prefixStr.isEmpty()) return "";
      }
    }

    return prefixStr;
  }

}
