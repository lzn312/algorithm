package review.一月.array;

public class _70_爬楼梯 {


    // 这里要注意一个小细节，我们开辟的数组一定是n+1，因为走到了n的台阶
    public int climb(int n) {
        if (n <= 2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
