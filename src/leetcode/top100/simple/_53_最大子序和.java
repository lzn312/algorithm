package leetcode.top100.simple;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 这题最重要的是在于[连续子数组]
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 **/
public class _53_最大子序和 {

    /**
     * 这题其实我还是不太理解。
     * 按照题解
     * 因为连续，可以使用求和，因为是连续,那么后一个数一定是与前面一个连续子数组的和相加的结果。
     * 关键是正向增益这一步怎么看,因为ans答案和sum是去最大连续子数组的值,那么就算增加sum比前面sum还小,但后面可能延续更高的最大和。
     * 如果产生了负向收益，那么则已经求出了到该节点为止的最大子数组和了。要从该节点继续往前推进
     **/
    public static int maxSubArray(int[] nums) {
        if (nums.length < 1) throw new IllegalArgumentException("nums 为空");
        if (nums.length == 1) return nums[0];
        int maxCurrentSum = 0;
        int ans = nums[0];
        for (int num : nums) {
            // 如果和相加大过了该节点，那么还是产生了正向增益
            if (maxCurrentSum + num > num) {
                maxCurrentSum += num;
            } else {
                // 否则从该节点起继续往前推进
                maxCurrentSum = num;
            }
            ans = Math.max(ans, maxCurrentSum);
        }
        return ans;
    }
    /**
     * 其实这题应该也是可以用动态方程来做可能更好理解
     * 假设dp[i]表示前i天最大的收益率那么这一题就转换为求动态方程了
     * 如果 dp[i-1]+nums[i] > 0
     *  dp[i] = max(dp[i-1], dp[i-1]+nums[i])
     *  否则
     *  dp[i] = max(dp[i-1],nums[i])
     **/
    public static int maxSubArrayByDp(int[] nums) {
        if (nums.length < 1) throw new IllegalArgumentException("nums 为空");
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        // 因为第0天使第一天的收益金额
        dp[0] = nums[0];
        for (int i = 1; i< nums.length;i++){
            if(dp[i-1] + nums[i] > 0){
                dp[i] = Math.max(dp[i-1], dp[i-1] + nums[i]);
            }else {
                dp[i] = nums[i];
            }


        }
       return dp[nums.length -1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, -2, 4, -5, -7, -3};
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArrayByDp(nums1));
    }
}
