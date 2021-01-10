package leetcode.字符串.回文串;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 **/
public class _5_最长回文子串 {

    /**
     * 这题两个点需要记住：
     *  1. 回文子串，可以用中心向外扩展的方法来做
     *  2. 使用dp来优化递归的过程
     **/
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return  s;
        }


        // 1. 我们可以用dp来做这一道题，难点就在于这个状态转义方程式怎么写了。

        /**
         * 我们设dp[left][right] = dp[left+1][right-1] && s.charAt(left) == s.charAt(right)
         *
         * dp[left][right]代表以left为起点，right为重点的字符串是否是回文字符串，它与其上一个dp状态关系还加上这一次的字符是否相等
         **/
        int len = s.length();
        String res = "";
        boolean[][] dp = new boolean[len][ len];
        for (int left = len -1 ; left >= 0; left--) {
            for (int right = left; right < len; right++) {

                // 判断当前dp的关系
                dp[left][right] =s.charAt(left) == s.charAt(right) &&

                        (      // 如果字符小于或等于1说明是回文字符串
                                right - left < 2
                                || dp[left + 1][right - 1 ]);

                // 如果相等就更新res
                if (dp[left][right] && right - left + 1 > res.length()) {
                    res = s.substring(left, right + 1);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        _5_最长回文子串 test = new _5_最长回文子串();
        System.out.println(test.longestPalindrome("babad"));
    }
}
