package leetcode.字符串.操作类;


/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *  
 *
 * 示例：
 *
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *  
 *
 * 提示：
 *
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 *
 **/
public class _557_反转字符串中的单词III {

    public String reverseWords(String s) {

        // 1. 边界判断
        if (s == null || s.length() == 0 || s.equals(" ")){
            return s;
        }

        StringBuilder stb = new StringBuilder(s);

        int left = 0;
        while (left <= stb.length() - 1) {
            int end = left;
            while (end < stb.length() && stb.charAt(end) != ' '){
               end++;
            }
            reverse(stb,left, end -1 );
            left = end + 1;
        }

        return stb.toString();

    }

    private void reverse(StringBuilder stb, int left, int end) {
        while (left <= end){
            char tmp  = stb.charAt(end);
            stb.setCharAt(end--, stb.charAt(left));
            stb.setCharAt(left++, tmp);
        }
    }

    public static void main(String[] args) {
        _557_反转字符串中的单词III test = new _557_反转字符串中的单词III();
        System.out.println(test.reverseWords("Let's take LeetCode contest"));
    }
}
