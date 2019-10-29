package leetcode.栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 **/
public class _20_有效的括号 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     **/


    private static HashMap<Character,Character> characterHashMap = new HashMap<>(4);
    static {
        characterHashMap.put('(',')');
        characterHashMap.put('{','}');
        characterHashMap.put('[',']');
    }
    // 骚操作, 因为一定有相连的两个括号 所以直接用replace使用
    public boolean isValid1(String s) {
        if (s.equals("")) return true;
        while (s.contains("{}") || s.contains("[]") || s.contains("()")){
            s = s.replace("{}","");
            s = s.replace("[]","");
            s = s.replace("()","");
        }
        return s.isEmpty();
    }


    // 可以使用栈来匹配操作
    public static boolean isValid2(String s) {
        if ( s == null ) return false;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i =0 ;i < len ; i++){
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c=='['){
                stack.push(c);
            }else {
               if (stack.isEmpty()) return false;
                Character c1 = stack.pop();
                if (c != characterHashMap.get(c1)) return false;
            }
        }

        return stack.isEmpty();
    }


    // 可以使用栈来匹配操作
    public static boolean isValid3(String s) {
        if ( s == null ) return false;
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i =0 ;i < len ; i++){
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c=='['){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                Character c1 = stack.pop();
                if ( c1 == '{'){
                    if (c != '}') return false;
                }else if (c1 == '('){
                    if (c != ')') return false;
                }else if (c1 == '['){
                    if (c != ']') return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([]";
        System.out.println(isValid2(s));
    }
}
