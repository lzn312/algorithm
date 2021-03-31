package leetcode.bytedance;

public class _53_最大子序和 {



    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        // dp[i] = i 结尾最大自序和
        int[] dp = new int[nums.length];
        int res = 0;
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int backVal = Math.max(dp[i-1], 0);
            dp[i] = nums[i] + backVal;
            res = Math.max(res, dp[i]);
        }
        return  res;
    }
}
