package leetcode.字符串.回文串;

public class _680_验证回文字符串Ⅱ {

    /**
     * 因为可删除，所以其实只要i+1,j || i, j -1 有任意一个是回文串则能保证成立
     **/
    public boolean validPalindrome(String s) {

        if (s == null || s.isEmpty() ){
            return true;
        }

        int len = s.length();
        int left = 0,right = len - 1  ;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)){
                return isValid(s, left + 1, right) || isValid(s, left, right -1 );
            }
            left++;
            right--;
        }

        return true;
    }


    private boolean isValid(String s, int left ,int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
