package leetcode.递归;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
 * 午
 **/
public class _17_电话号码的字母组合 {


    /**
     * 组合类型的题目一般都是递归，我们还是按照递归的思想来看看。
     * 其实本质和前面是一样的，我有三个数组，每次从上面可以选出一个字符，然后把字符追加到当前的字符串中。
     * 本身和n个格子是一样的。
     **/
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> numberCharTable = buildNumberCharTable();
        innerLetterCombinations(
                "",
                digits,
                numberCharTable,
                res,
                0);
        return res;

    }

    private void innerLetterCombinations(String curChar, String digits, Map<Character, String> numberCharTable, List<String> res, int index) {
        // terminate

        if (index == digits.length()) {
            res.add(curChar);
            return;
        }

        // process
        String lowChar = numberCharTable.get(digits.charAt(index));
        for (int i = 0; i < lowChar.length(); i++) {
            innerLetterCombinations(curChar + lowChar.charAt(i), digits, numberCharTable, res, index + 1);
        }

    }

    private Map<Character, String> buildNumberCharTable() {
        Map<Character, String> result = new HashMap<>();
        result.put('2', "abc");
        result.put('3', "def");
        result.put('4', "ghi");
        result.put('5', "jkl");
        result.put('6', "mno");
        result.put('7', "pqrs");
        result.put('8', "tuv");
        result.put('9', "wxyz");
        return result;
    }


    public static void main(String[] args) {
        _17_电话号码的字母组合 test = new _17_电话号码的字母组合();
        System.out.println(test.letterCombinations("23"));
    }
}
