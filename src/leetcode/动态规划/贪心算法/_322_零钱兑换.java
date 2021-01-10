package leetcode.动态规划.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 **/
public class _322_零钱兑换 {


    /**
     * 零钱兑换是典型的贪心算法，贪心算法主要是用来解决最值问题。而最值问题，则可以划分为整体最优和局部最优。
     * 但是贪心算法是局部最优解。 这样是有局限的，所以如果要整体最优可能会舍弃部分最优解。这就会用到了回溯。
     * <p>
     * 我们可以考虑，其实我们这里转换的就是最小值问题。 而零钱兑换就是使用递归来解决。
     * 我们可以先对面值进行排序，排序后我们从面值最大的钱开始找，如果面值最大的钱能全部兑换完，那说明这肯定是最小计数值。因为它是局部最优解。
     * 但是有一个问题就是，可能我这个面值在往下找的时候其实只要倒退一次就能得到最优解，所以我们需要考虑回溯。
     **/
    public int coinChange(int[] coins, int amount) {
        // 先进行排序
        Arrays.sort(coins);
        for (int i = 0; i < coins.length >> 1; i++) {
            int tmp = coins[coins.length - 1 - i];
            coins[coins.length - 1 - i] = coins[i];
            coins[i] = tmp;
        }
        return coinCount(coins, 0, 0, amount);

    }

    private int coinCount(int[] coins, int level, int count, int retainCoin) {
        return -1;
    }


    public static void main(String[] args) {
        _322_零钱兑换 test = new _322_零钱兑换();
        int[] coins = {186, 419, 83, 408};
        System.out.println(test.coinChange(coins, 6249));
    }
}
