package leetcode.字符串.操作类;


/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 **/
public class _917_仅仅反转字母 {

    public String reverseOnlyLetters(String s) {

        if ( s == null || s.length() == 0 ){
            return s;
        }


        // 2. reverse char
        StringBuilder stb = new StringBuilder(s);


        int left =0,right = s.length() - 1;

        while (left < right ){
            while (left < right && isChar(stb.charAt(left))) {
                left++;
            }

            while (left < right && isChar(stb.charAt(right))) {
                right--;
            }
            if (left >= s.length() || right < 0) break;
            char tmp = stb.charAt(right);
            stb.setCharAt(right--, stb.charAt(left));
            stb.setCharAt(left++, tmp);
        }

        return stb.toString();
    }



    private boolean isChar(char c){
       return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z');
    }


    public static void main(String[] args) {
        _917_仅仅反转字母 test = new _917_仅仅反转字母();
        System.out.println(test.reverseOnlyLetters("ab-cd"));
        System.out.println(test.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(test.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(test.reverseOnlyLetters("7_28]"));
        System.out.println(test.reverseOnlyLetters("?6C40E"));
    }
}
