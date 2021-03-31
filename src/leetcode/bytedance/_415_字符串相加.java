package leetcode.bytedance;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 **/
public class _415_字符串相加 {

    /**
     *
     **/
    public String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();

        int n1Right = num1.length() -1;
        int n2Right = num2.length() -1 ;
        int overFlow = 0;
        while (n1Right >= 0 || n2Right >= 0) {
            int n1 = n1Right >= 0 ? num1.charAt(n1Right) - '0' : 0;
            int n2 = n2Right >= 0 ? num2.charAt(n2Right) - '0' : 0;
            int tmp = n1 + n2 + overFlow;
            overFlow = tmp / 10;
            res.append(tmp % 10);
            n1Right--;
            n2Right--;
        }

        if (overFlow > 1) res.append(1);

        return res.reverse().toString();

    }





}
