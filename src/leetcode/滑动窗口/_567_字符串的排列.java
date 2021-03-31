package leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 提示：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class _567_字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        // 构建cacheMap
        Map<Character,Integer> needMap = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            needMap.put(s1.charAt(i), needMap.getOrDefault(s1.charAt(i), 0) + 1);
        }


        int left=0,right=0,valid = 0;
        Map<Character,Integer> window = new HashMap<>(s1.length());
        while (right < s2.length()) {
            // 处理右节点数据
            char r = s2.charAt(right);
            right++;
            if (needMap.containsKey(r)) {
                window.put(r, window.getOrDefault(r,0) + 1);
                if (window.get(r).equals(needMap.get(r))) {
                    valid++;
                }
            }



            // 处理左边窗口
            while (right - left >= s1.length()) {
                if (valid == needMap.size()) {
                    return true;
                }

                char l = s2.charAt(left);
                left++;
                // 处理左节点数据
                if (needMap.containsKey(l)) {
                    if (window.get(l).equals(needMap.get(l))) {
                        valid--;
                    }
                    window.put(l,window.getOrDefault(l,0) -1);
                }

            }
        }

        return false;
    }

    public  static boolean checkInclusion1(String s1, String s2) {
    int[] need = new int[26];
    int[] window = new int[26];
    int left = 0, right = 0;
    int valid = 0;
    int count = 0;
        for (int i = 0; i < s1.length(); i++) {
        need[indexOf(s1.charAt(i))]++;
        if (need[indexOf(s1.charAt(i))] == 1) count++;
    }
        while (right < s2.length()) {
        // process right cursor
        char r = s2.charAt(right++);
        window[indexOf(r)]++;
        if (need[indexOf(r)] > 0 && window[indexOf(r)] == need[indexOf(r)]) {
            valid++;
        }


        // process left cursor
        while (right - left >= s1.length()) {
            if (valid == count){
                return true;
            }
            char l  = s2.charAt(left++);
            if (need[indexOf(l)] > 0 && need[indexOf(l)] == window[indexOf(l)]){
                valid--;
            }
            window[indexOf(l)]--;
        }
    }

        return false;
}

    private static int indexOf(char lowCase) {
        return lowCase - 'a';
    }


    public static void main(String[] args) {
//        System.out.println(checkInclusion("ab",
//                "eidbaooo"));

//        System.out.println(checkInclusion("ab",
//                "eidboaoo"));
        System.out.println(checkInclusion1("ab",
                "eidboaoo"));
    }
}
