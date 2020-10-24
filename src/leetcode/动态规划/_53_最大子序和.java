package leetcode.动态规划;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 **/
public class _53_最大子序和 {

    /**
     * 我特么就是不会做动态规划，动态规划的核心就是写出状态转移方程和定量的已知条件。
     * 这题要我们求连续的子数组和的最大值，我们不妨就假设一下状态转移方程式:
     * 1. dp[i] = nums[i] 结尾的最大连续的子数组和
     * 为啥要这么定义的呢，我们看一下我们这么定义的好处。
     * 对于dp[i] 的值 是不是就可以假设为 是dp[i-1] 与nums[i] 之和。
     * 这样的话，dp[i]的值就有迹可循了。 但是我们细想一下 如果dp[i-1]的值是负数，那么 dp[i] 的最大值就是 nums[i] . 所以我们得到了两个方程式
     * dp[i] = nums[i] + dp[i-1] (if dp[i-1] >= 0)
     * dp[i] = nums[i] (if dp[i-1] < 0)
     * 这里在注意一下我们要返回的结果是最大值，所以最后我们需要在这个dp[] 中找到最大值
     * int result = max(dp[0] - d[ n -1 ])
     **/
    public int maxSubArray(int[] nums) {
        // 临界条件注意
        if (nums.length == 1){
            return nums[0];
        }


        // 定义dp数组
        int[] dp = new int[nums.length];
        // 定义已知条件
        dp[0] = nums[0];

        int result = dp[0];

        for (int i = 1; i < nums.length; i++) {
            int backTracking = Math.max(nums[i], 0);
            dp[i] = nums[i] + backTracking;
            result = Math.max(dp[i], result);
        }


        // 找到最大值
        return result;
    }
}
