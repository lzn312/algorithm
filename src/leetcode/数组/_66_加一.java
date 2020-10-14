package leetcode.数组;

import java.util.Arrays;

/**
 * @author Leezer
 * @date 2020/10/14 9:35 上午
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 **/
public class _66_加一 {

    /**
     * 其实这题比较简单，并且也说明了几个重要的条件:
     * 1. 除了整数 0 之外，这个整数不会以零开头。 也就是不会有特殊的情况需要考虑。
     * 2. 非负整数同1.
     * 3. 相加的情况需要考虑，两个9： 首位为9进1时，需要特殊扩容+1 eg： 99 其他情况需要向上一位进1
     **/
    public static int[] plusOne(int[] digits) {
        boolean plusOverFlow = false;

        int val = digits[digits.length - 1];
        if (val == 9) {
            plusOverFlow = true;
            val = 0;
        } else {
            val++;
        }
        digits[digits.length - 1] = val;

        for (int i = digits.length - 2; i >= 0; i--) {
            int valFor = digits[i];
            // 如果存在溢出
            if (plusOverFlow) {
                if (valFor == 9) {
                    valFor = 0;
                } else {
                    valFor++;
                    plusOverFlow = false;
                }
            }
            digits[i] = valFor;
        }

        // 首位有特殊位9
        if (plusOverFlow) {
            int[] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            System.arraycopy(digits, 0, newResult, 1, digits.length);
            return newResult;
        }
        return digits;
    }

    public static int[] plusOneSimple(int[] digits, int val) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        int[] test2 = {1, 2, 9};
        int[] test3 = {9, 9};

        System.out.println(Arrays.toString(plusOne(test)));
        System.out.println(Arrays.toString(plusOne(test2)));
        System.out.println(Arrays.toString(plusOne(test3)));
    }

}
