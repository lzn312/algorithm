package leetcode.字符串;


import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class Palindrome {


    /**
     * 是否是回文数
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "race a car"
     * 输出: false
     **/
    public static boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return false;
        } else {
            if (s.length() == 1) {
                return false;
            } else {
                int head = 0;
                int tail = s.length() - 1;

                while (head <= tail) {
                    if (!Character.isLetterOrDigit(s.charAt(head))) {
                        head++;
                    }else if (!Character.isLetterOrDigit(s.charAt(tail))) {
                        tail--;
                    }else {
                        if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(tail))) {
                            return false;
                        } else {
                            head++;
                            tail--;
                        }
                    }
                }
            }
            return true;
        }
    }


    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     *
     * 返回 s 所有可能的分割方案。
     *
     * 示例:
     *
     * 输入: "aab"
     * 输出:
     * [
     *   ["aa","b"],
     *   ["a","a","b"]
     * ]
     **/

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.isEmpty()){
            return result;
        }else {

        }
        return result;
    }


}
