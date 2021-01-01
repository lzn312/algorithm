package leetcode.top100.middle;

/**
 * @author Leezer
 * @date 2020/12/27 上午11:19
 **/
public class _152_乘积最大子数组 {

    /**
     * 这一题我感觉可以使用递归来做
     **/
    public int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }


        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currRes = dp[i - 1] * nums[i];
            if (currRes < dp[i - 1] || currRes < nums[i]) {
                currRes = nums[i];
            }

            dp[i] = currRes;
        }


        int maxRes = 0;
        for (int val : dp) {
            maxRes = Math.max(maxRes, val);
        }
        return maxRes;
    }


    public static void main(String[] args) {
        _152_乘积最大子数组 test = new _152_乘积最大子数组();
//        System.out.println(test.maxProduct(new int[]{-2, 0, -1}));
//        System.out.println(test.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(test.maxProduct(new int[]{0,2}));
    }

}
