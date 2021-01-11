package leetcode.字符串.异位词;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
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






    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  res = new ArrayList<>();
        if (s.length() == 0 || s.length() < p.length()){
            return res;
        }

        int[] cache = new int[26];
        // 构建缓存集合
        for (int i = 0; i < p.length(); i++) {
            cache[p.charAt(i) - 'a']++;
        }


        // 遍历s字符串
        for (int i = 0; i < s.length(); i++) {
            int searchIndex = i;
            int[] searchCache = new int[26];
            int endIndex = i + p.length() -1 ;
            while (searchIndex < s.length() &&  searchIndex <= endIndex){
                searchCache[s.charAt(searchIndex++) - 'a']++;
            }

            // 比较数据
            boolean flag = true;
            for (int j = 0; j < searchCache.length; j++) {
                if (searchCache[j] != cache[j]) {
                   flag = false;
                   break;
                }
            }

            if (flag) res.add(i);


        }



        return res;
    }


    public static void main(String[] args) {
        _438_找到字符串中所有字母异位词 test = new _438_找到字符串中所有字母异位词();

        System.out.println(test.findAnagrams("cbaebabacd", "abc"));
        System.out.println(test.findAnagrams("abab", "ab"));
    }
}
