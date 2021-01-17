package leetcode.字符串.操作;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 说明：
 * <p>
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * <p>
 * 输入："a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 4：
 * <p>
 * 输入：s = "  Bob    Loves  Alice   "
 * 输出："Alice Loves Bob"
 * 示例 5：
 * <p>
 * 输入：s = "Alice does not even like bob"
 * 输出："bob like even not does Alice"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 *  
 * <p>
 * 进阶：
 * <p>
 * 请尝试使用 O(1) 额外空间复杂度的原地解法。
 **/
public class _151_翻转字符串里的单词 {


    /**
     * 如果
     **/
    public String reverseWords(String s) {

        if (s == null || s.isEmpty() || s.equals(" ")) {
            return "";
        }


        // 1. 全部倒序排列
        StringBuilder stb = trimSpace(s);
        reverse(stb, 0, stb.length() - 1);

        // 倒排每一个单词
        innerReverseWorld(stb);
        return stb.toString();
    }

    private void innerReverseWorld(StringBuilder stb) {
        int left = 0;

        while (left <= stb.length() - 1){
            int end = left;
            while (end <= stb.length() -1 && stb.charAt(end) != ' '){
                ++end;
            }
            reverse(stb, left, end -1 );

            left = end + 1;
        }
    }

    private  StringBuilder trimSpace(String s) {
        int left = 0, right = s.length() - 1;

        StringBuilder stb = new StringBuilder();

        while ( left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        while (right >= 0 && s.charAt(right) == ' ') {
            --right;
        }


        // 过滤中间多余的空格
        while (left <= right ){
            if (s.charAt(left) != ' '){
                stb.append(s.charAt(left));
            }else if (stb.charAt(stb.length() - 1 ) != ' '){
                stb.append(s.charAt(left));
            }
            left++;
        }

        return stb;
    }

    private void reverse(StringBuilder stb, int left, int right) {

        while (left <= right) {
            char tmp = stb.charAt(right);
            stb.setCharAt(right, stb.charAt(left));
            stb.setCharAt(left, tmp);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {

        _151_翻转字符串里的单词 test = new _151_翻转字符串里的单词();
        System.out.println(test.reverseWords("the sky is blue"));
        System.out.println(test.reverseWords("a good   example"));
    }
}
