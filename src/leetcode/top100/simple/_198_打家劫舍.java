package leetcode.top100.simple;
/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * https://leetcode-cn.com/problems/house-robber
 **/
public class _198_打家劫舍 {
    /**
     * 这题应该是动态规划的题，但是我还是不会做
     * 所以先考虑最简单的方法：使用奇偶数来做
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * XXX 这种做法不对，因为这是考虑连续的情况下。但其实他也可以连续两楼不偷这种情况他的收益指就是前两楼的和
     **/
    public static int robError(int[] nums) {
        int oddNumbers = 0;
        int evenNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                evenNumbers += nums[i];
            }else {
                oddNumbers += nums[i];
            }
        }
        return Math.max(oddNumbers, evenNumbers);
    }
    /**
     * 该做法延续上面的思想，但是我们可以在往深处考虑，如果他不偷当前楼，亦或当前不偷这楼能投下楼的收益比较大，那么我们手上最大金额就是
     * 前几楼的最大值
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     **/
    public  int rob1(int[] nums) {
        int oddNumbers = 0;
        int evenNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0){
                evenNumbers += nums[i];
                //他可能上一次没抢 所以钱数为前面最大
                evenNumbers = Math.max(oddNumbers, evenNumbers);
            }else {
                oddNumbers += nums[i];
                oddNumbers = Math.max(oddNumbers, evenNumbers);
            }
        }
        return Math.max(oddNumbers, evenNumbers);
    }

    /**
     * 这题应该使用动态规划来做:
     *     1. 找到方程组的最优解方案且满足条件的方案
     *      需要不连续获取钱财 假设有奇数楼情况[1,2,3],则钱财最大为4
     *      假设有偶数楼的情况[1,1,1,3] 则最大钱财为4
     *     2. 列出状态转移方程
     *     假设dp[n]代表到第n个房屋的钱财,那么dp[n]最大值可能是两种情况
     *     dp[n] = dp[n-1] 代表第n-1偷了，第n房间不能偷
     *     dp[n] = dp[n-2] + num 代表你n房间偷了，加上第n-2最大钱财数
     *     那么dp[n] = max( dp[n-1], dp[n-2] + num)
     *     3. 初始状态
     *     dp[0] = 0 代表前0间房子的最大钱财数
     *     4. 返回结果 dp[n]为最大收益
     *     时间复杂度：O（n)
     *     空间复杂度: O(n)
     **/
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
    /**
     * 改进上一版本
     * 我们发现dp其实只和前一个状态和前前状态有关
     * 那么空间复杂度是可以优化的
     **/
    public static int robR(int[] nums) {
        int pre = 0;
        int current = 0;
        // 置换过后需要把pre更新
        int tmp;
        for (int num : nums) {
            tmp = current;
            current = Math.max(current, pre + num);
            pre = tmp;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
         nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
