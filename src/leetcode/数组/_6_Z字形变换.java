package leetcode.数组;

import java.util.Arrays;

/**
 * @author Leezer
 * @date 2020/10/18 10:23 上午
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *

 **/
public class _6_Z字形变换 {


    /**
     * 这题我没啥思路，其实难点就在于周期怎么定的，我们可以每个行都存一个数组
     * 然后通过数组去看怎么变换。问题就是在于怎么拿到它们的规律。
     * 规律就直说是 2*n -2 为周期，需要变换
     **/
    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 1) {
            return s;
        }
        // 定义周期
        int period = numRows * 2 - 2;
        // 需要这么多个数组进行存取
        String[] rowArray = new String[numRows];
        Arrays.fill(rowArray, "");
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 根据周期取模
            int mod = i % period;
            // 如果他在周期内，就直接放到对应的数组
            if (mod < numRows) {
                rowArray[mod] += chars[i];
            }else {
                // 如果超过周期,则用mod 和 间隔就能获取到对应的数组下标
                rowArray[period - mod] += chars[i];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : rowArray) {
            stringBuilder.append(s1);
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 3));
    }
}
