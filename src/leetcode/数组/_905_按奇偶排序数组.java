package leetcode.数组;

import java.util.Arrays;

/**
 *给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 **/
public class _905_按奇偶排序数组 {


    public int[] sortArrayByParity(int[] A) {
        if (A.length <= 1) {
            return A;
        }

        int evenIndex = 0;

        for (int i = 0; i < A.length; i++) {
            // 如果当前元素是偶数，则移动其位置
            if (A[i] % 2 == 0) {
                if (i == evenIndex) {
                    evenIndex++;
                    continue;
                }
                int temp = A[evenIndex];
                A[evenIndex] = A[i];
                A[i] = temp;
                evenIndex++;
            }
        }

        return A;

    }


    public static void main(String[] args) {
        _905_按奇偶排序数组 test =new _905_按奇偶排序数组();
        System.out.println(Arrays.toString(test.sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
