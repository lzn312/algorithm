package leetcode.字符串.基础;

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
 **/
public class _387_字符串中的第一个唯一字符 {

    /**
     * 我们假设就只有小写字母，那么就26个字符，
     * 我们可以用一个Map存储26个字母出现的次数，然后在便利一边返回
     **/
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>(26);

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.merge(aChar, 1, Integer::sum);
        }

        int result = -1;
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return result;

    }
}
