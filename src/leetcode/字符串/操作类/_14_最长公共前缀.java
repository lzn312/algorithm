package leetcode.字符串.操作类;

import leetcode.everyday._142_环形链表II;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 **/
public class _14_最长公共前缀 {


    public String longestCommonPrefix(String[] strs) {
        // 1. 如果为空则直接返回空
        if (strs == null || strs.length == 0){
            return "";
        }

        StringBuilder res = new StringBuilder();

        for (int column = 0; column < strs[0].length(); column++) {
            char curChar = strs[0].charAt(column);
            boolean addFlag = true;
            for (int row = 1; row < strs.length; row++) {
                if (strs[row].length()  <=  column
                        ||  strs[row].charAt(column) != curChar) {
                    addFlag = false;
                    break;
                }
            }
            if (!addFlag) {
                break;
            }
            res.append(curChar);
        }

        return res.toString();
    }


    public static void main(String[] args) {
        _14_最长公共前缀 test = new _14_最长公共前缀();
        System.out.println(test.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(test.longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }
}
