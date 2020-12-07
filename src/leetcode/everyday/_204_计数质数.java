package leetcode.everyday;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *  
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 *
 *
 **/
public class _204_计数质数 {

    /**
     * 埃氏筛选， 原意就是从现在开始的i*i， 没过一个x 的i倍，都肯定不是其质数
     **/
    public int countPrimes(int n) {
        // 我们可以填充一个数组用来记录其质数，
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);

        // 因为0，1不是质数。
        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i*i; j < n ; j += i) {
                    prime[j] = false;
                }
            }
        }


        int count = 0;
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                count++;
            }
        }
        return count;
    }
}
