package leetcode.字符串.异位词;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 *
 *
 **/
public class _242_有效的字母异位词 {

    public boolean isAnagram(String s, String t) {

        if (s.length()  != t.length() ) {
            return false;
        }

        Map<Character,Integer> cacheCharMap = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
            cacheCharMap.put(s.charAt(i), cacheCharMap.getOrDefault(s.charAt(i), 0) + 1);
            cacheCharMap.put(t.charAt(i), cacheCharMap.getOrDefault(t.charAt(i), 0 ) - 1);
        }

        for (Integer count : cacheCharMap.values()) {
            if (count != 0 ) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        _242_有效的字母异位词 test = new _242_有效的字母异位词();
        System.out.println(test.isAnagram("anagram", "nagaram"));
    }
}
