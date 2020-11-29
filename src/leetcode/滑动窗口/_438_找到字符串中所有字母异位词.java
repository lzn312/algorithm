package leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 **/
public class _438_找到字符串中所有字母异位词 {

    public List<Integer> findAnagrams(String s, String p ) {
        if (s == null || p == null || s.isEmpty() || p.isEmpty() || s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        // 构建数据索引
        int[] pArray = new int[26], sArray = new int[26];

        // 构建初始映射表
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a' ]++;
            sArray[s.charAt(i) - 'a' ]++;
        }

        int left = 0;
        int right = p.length();


        while (right < s.length()) {
            if (isSame(pArray, sArray)) {
                result.add(left);
            }

            sArray[s.charAt(right) - 'a']++;
            sArray[s.charAt(left) - 'a']--;

            left++;
            right++;
        }


        if (isSame(pArray, sArray)) {
            result.add(left);
        }
        return result;

    }

    private boolean isSame(int[] pArray, int[] sArray) {
        for (int i = 0; i < pArray.length; i++) {
            if (pArray[i] != sArray[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _438_找到字符串中所有字母异位词 test = new _438_找到字符串中所有字母异位词();
        System.out.println(test.findAnagrams("aa", "bb"));
    }
}
