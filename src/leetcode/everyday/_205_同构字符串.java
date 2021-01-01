package leetcode.everyday;

import java.util.*;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 *
 **/
public class _205_同构字符串 {



    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length() ){
            return false;
        }


        int[] sBuild = new int[128];
        int[] tBuild = new int[128];


        Arrays.fill(sBuild, -1);
        Arrays.fill(tBuild, -1);

        for (int i = 0; i < s.length(); i++) {
            // 如果两个同构，说明他们的下标索引应该是一致的，如果其不等时，例如 ab, aa. => 第二位就会有异常
            if (sBuild[s.charAt(i)] != tBuild[t.charAt(i)]){
                return false;
            }
            sBuild[s.charAt(i)] = i;
            tBuild[t.charAt(i)] = i;
        }

        return true;
    }

    public static void main(String[] args) {
        _205_同构字符串 test = new _205_同构字符串();
//        System.out.println(test.isIsomorphic("foo","bar"));
        System.out.println(test.isIsomorphic("egg","add"));
//        System.out.println(test.isIsomorphic("ab","aa"));
    }
}
