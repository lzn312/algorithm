package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class _76_最小覆盖子串 {

    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>(s.length());
        Map<Character, Integer> need = new HashMap<>(t.length());
        for ( int i = 0; i < t.length(); i ++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        while (right < s.length()) {
            // process right cursor
            char r  = s.charAt(right++);
            window.put(r, window.getOrDefault(r, 0) + 1);
            if ( window.get(r).equals(need.getOrDefault(r, 0))) {
                valid++;
            }

            // process left cursor
            while ( valid == need.size()){
                // min str
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                char l = s.charAt(left++);
                if (need.containsKey(l)) {
                    if ( window.get(l).equals(need.get(l))){
                        valid--;
                    }
                }
                window.put(l, window.get(l) - 1);
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start +len) ;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC",
                "ABC"));
    }

}
