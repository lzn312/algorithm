package leetcode.top100.hard;

import java.util.Stack;

/**
 *给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 *
 **/
public class _32_最长有效括号 {


    /**
     * 我们使用一个栈来做这个题就可以了。
     **/
    public int longestValidParentheses(String s) {

        if (s.length() < 2){
            return 0;
        }

        // 我们定义一个栈

        int count = 0;
        Stack<Character> tmp = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            // 如果是'(' 就存入栈 ，如果是')' 就弹出
            char indexChar = s.charAt(i);
            if (indexChar == '(') {
                tmp.push(indexChar);
            }else {
                if ( !tmp.isEmpty() ){
                    tmp.pop();
                    count += 2;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        _32_最长有效括号 test = new _32_最长有效括号();
        System.out.println(test.longestValidParentheses("((()))"));
        System.out.println(test.longestValidParentheses(")()())"));
    }
}
