package leetcode.字符串.异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 **/
public class _49_字母异位词分组 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> sortStrMap = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26];

            for (char c : str.toCharArray()) {
                counts[c - 'a']++;
            }

            StringBuilder stb = new StringBuilder();


            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0 ){
                    stb.append( (char) i + 'a');
                    stb.append(counts[i]);
                }
            }


            String key = stb.toString();
            List<String> group = sortStrMap.getOrDefault( key , new ArrayList<String>());
            group.add(str);
            sortStrMap.put( key , group);
        }

        List<List<String>> res = new ArrayList<>(sortStrMap.values());

        return res;
    }


    public static void main(String[] args) {
        _49_字母异位词分组 test = new _49_字母异位词分组();
        System.out.println(test.groupAnagrams(new String[]{ "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
