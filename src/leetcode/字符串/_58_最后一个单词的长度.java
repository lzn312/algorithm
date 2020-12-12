package leetcode.字符串;


/**
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 **/
public class _58_最后一个单词的长度 {


    /**
     * 这题好像没啥难度，但要注意是否有坑
     * 因为可能最后一个字符也是空格，我们需要掠过他
     **/
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.equals(" ")){
            return 0;
        }
        int count = 0 ;
        for (int i = s.length() -1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }
}
