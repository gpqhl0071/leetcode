import java.util.Stack;

public class gp20 {
  public boolean isValid(String s) {

    int l = s.length();

    int a = 0, b = 0, c = 0;
    Stack<String> lastSign = new Stack<>();

    for (int i = 0; i < l; i++) {
      String str = String.valueOf(s.charAt(i));

      if (str.equals("(")) {
        a++;
        lastSign.push(str);
      } else if (str.equals("[")) {
        b++;
        lastSign.push(str);
      } else if (str.equals("{")) {
        c++;
        lastSign.push(str);
      } else if (str.equals(")")) {
        if (lastSign.isEmpty() || !lastSign.pop().equals("(")) {
          return false;
        }
        a--;
      } else if (str.equals("]")) {
        if (lastSign.isEmpty() || !lastSign.pop().equals("[")) {
          return false;
        }
        b--;
      } else if (str.equals("}")) {
        if (lastSign.isEmpty() || !lastSign.pop().equals("{")) {
          return false;
        }
        c--;
      }
    }

    if (a == 0 && b == 0 && c == 0) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    gp20 gp = new gp20();
    System.out.println(gp.isValid("]}"));
  }

}
