package leetcode.字符串.操作类;


/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 说明：
 *
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 示例 1：
 *
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 *
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 *
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *  
 *

 **/
public class _151_翻转字符串里的单词 {

    // 先反转整个字符，在翻转有效单词
    public String reverseWords(String s) {
        if (s == null || s.isEmpty() || s.equals(" ") ){
            return "";
        }

        // 翻转整个字符？
        return "";
    }


    public static void main(String[] args) {
        _151_翻转字符串里的单词 v = new _151_翻转字符串里的单词();
        System.out.println(" 21 asd ".trim());
    }
}
