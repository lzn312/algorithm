package leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 **/
public class _300_最长上升子序列 {

    /**
     * 这题的思路和上一道是差不多的，我们可以分为两个步骤
     * 第一个步骤是设状态转移方程：
     * 1. 假设dp[i] 表示以 nums[i] 前的最大上升子序列长度的话，那么问题就变成了。在dp[i]中找到max的值就行了。
     * 第二个步骤就是找规律
     * 但是现在问题在于如果这么假设的话，我无法知道dp[i] 和 dp[i -1 ]之间的关系。 这里的话实属我自己思维局限了，为什么一定要是i-1呢？？？？（重点）
     * 我们应该放开，找到的是如果 dp[0 in i -1] 内存在nums[j] 比它小，那么他的最大上升子序列就是 dp[j] + 1.
     * 但是这里我们会注意，他可能存在多种情况 的 dp[j] / dp [k] / dp[l] 的 nums[j,k,l] 都比它小，这里就容易卡壳。。。虽然我都没想这里
     * 那么根据我们的的定义，max(dp[j],dp[k],dp[l]) 就行了
     * <p>
     * 可是我特么就是没想出来
     **/
    public static int lengthOfLIS(int[] nums) {

        // 边界值判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        // 定义 dp 方程
        int[] dp = new int[nums.length];

        // 获取已知条件
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            int res = 0;

            // 比较最长上升子序列的长度
            for (int j = i; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    res = Math.max(res, dp[j]);
                }
            }
            // 如果存在就在它基础上+1.否则就为1
            dp[i] = res + 1;
        }


        // 比较最大值
        int result = dp[0];
        for (int i = 1; i < dp.length; i++) {
            result = Math.max(dp[i], result);
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS(new int[]{-2,-1}));
    }


}
