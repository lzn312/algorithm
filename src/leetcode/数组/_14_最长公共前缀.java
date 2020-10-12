package leetcode.数组;

import java.util.Stack;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 **/
public class _14_最长公共前缀 {

    /**
     * 这题其实没啥考查点，我理解的就是，我们要通过某个方法找到他的前缀，
     * 那么一定时所有元素包含这个前缀，我们可以初始化这个前缀之后，把它和所有的字符串进行比较，
     * 如果比较之后发现有包含关系，那么我们就确定时包含它的，如果没有，我们就使他缩小一个字符，在进行比较。
     * 另外需要注意的时临界条件的判断。
     **/
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String index = strs[0];

        for (String str : strs) {
            if (index.length() == 0) {
                return "";
            }
            int result = str.indexOf(index);
            if (result != 0) {
                while (true) {
                    if (index.length() == 0) {
                        return "";
                    }
                    index = index.substring(0, index.length() - 1);
                    int res = str.indexOf(index);
                    if (res == 0) {
                        break;
                    }

                }

            }
        }
        return index;
    }


    public static void main(String[] args) {
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));

        String[] strs2 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs2));


    }
}
