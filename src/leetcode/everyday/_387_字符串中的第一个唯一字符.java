package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 **/
public class _387_字符串中的第一个唯一字符 {


    public int firstUniqChar(String s) {
        if (s.length() == 0 ){
            return -1;
        }

        Map<Character,Integer> map = new HashMap<>(26);

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar, 1, Integer::sum);
        }

        int result = -1;
        // 这里是利用chars自身的有序性，就能得到第一个唯一字符串了
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return result;

    }



    public static void main(String[] args) {
        _387_字符串中的第一个唯一字符 v = new _387_字符串中的第一个唯一字符();
        System.out.println(v.firstUniqChar("leetcode"));
        System.out.println(v.firstUniqChar("loveleetcode"));
    }
}
