package leetcode.滑动窗口;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 **/
public class _3_无重复字符的最长子串 {



    /**
     * 这题可以用滑动窗口来做，我们只需要找到无重复字串的长度，所以我们只需要把它放入到一个窗口里面，这个窗口里面如果有重复的值，
     * 我们就把它给删除调放入现有的值。这样的话我们就可以的到这个无重复的最长字串长度了
     * 滑动窗口:
     * ，一般是考察字符串的匹配。比较标准的题目，会给出一个模式串B，以及一个目标串A。然后提出问题，
     * 找到A中符合对B一些限定规则的子串或者对A一些限定规则的结果，最终再将搜索出的子串完成题意中要求的组合或者其他。
     **/
    public  int lengthOfLongestSubstring(String s) {
        int n = s.length(), result = 0;
        int[] charIndex = new int[256];
        for (int right = 0, left = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c],left);
            result = Math.max(result, right - left + 1);
            charIndex[c] = right + 1;
        }
        return result;
    }



    public  static int lengthOfLongestSubstring1(String s) {
        if (s.length() == 1 ) return 1;

        int res = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right <= s.length() -1 ){
            char r = s.charAt(right++);
            window.put(r, window.getOrDefault(r,0) + 1);



            while (window.get(r) > 1) {
                char l = s.charAt(left++);
                window.put(l, window.get(l) -1 );
            }
            res = Math.max(res, right - left);
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("cbacdcbc"));
//        System.out.println(lengthOfLongestSubstring1("bbbbbbbbbbbbbb"));
    }
}
