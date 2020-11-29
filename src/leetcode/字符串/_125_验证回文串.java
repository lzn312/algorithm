package leetcode.字符串;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 **/
public class _125_验证回文串 {
    /**
     * 这题和反转字符串的思路差不多，比较收尾元素字符是否相等，
     * 如果不等，则不是回文串，空格则跳过继续。
     * 终止条件就是，左下标 < 右下标
     **/
    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        while (leftIndex < rightIndex) {
            char leftChar = s.charAt(leftIndex);
            if (!((leftChar >= '0' && leftChar <= '9') || (leftChar >= 'a' && leftChar <= 'z'))) {
                leftIndex++;
                continue;
            }
            char rightChar = s.charAt(rightIndex);
            if (!((rightChar >= '0' && rightChar <= '9') || (rightChar >= 'a' && rightChar <= 'z'))) {
                rightIndex--;
                continue;
            }
            if (leftChar!= rightChar) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
