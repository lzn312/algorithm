package leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 **/
public class _20_有效的括号 {

        public boolean isValid(String s) {
            if (s.length() == 1)  return false;

            Map<Character, Character> relationTable = initSupCharacterMap();

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '{'|| c == '['){
                    stack.push(c);
                }else {
                    if (stack.isEmpty()) return false;
                    if (relationTable.get(stack.pop()) != c) {
                        return false;
                    }
                }
            }
            return true;

        }



        private Map<Character, Character> initSupCharacterMap(){
            Map<Character, Character> characterMap = new HashMap<>(4);
            characterMap.put('(',')') ;
            characterMap.put('[',']') ;
            characterMap.put('{','}') ;

            return characterMap;
        }


}
