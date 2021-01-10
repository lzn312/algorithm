package leetcode.字符串.回文串;


/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 **/
public class _125_验证回文串 {


    public boolean isPalindrome(String s) {

        if (s == null || s.isEmpty() ){
            return true;
        }

        s =s.toLowerCase();
        int len = s.length();
        int left = 0,right = len - 1  ;

        while (left < right) {
            while (left < len && isNormalChar(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && isNormalChar(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    private boolean isNormalChar(char c){
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }
    public static void main(String[] args) {
        _125_验证回文串 test = new _125_验证回文串();

        System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
