package leetcode.top100.simple;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 **/
public class _121_买卖股票的最佳时机 {
    /**
     * 有点类似最大子序和 XXX 动态规划问题还是不容易去理解啊
     * 那么这题就是动态规划问题
     * (1. 规模最小的情况
     * 将问题问法定义成状态，即dp[i]时表示在天数[0,i]之间最大的利润,但是思考状态转移方程时，发现dp[i]之前可能表示dp[i-1]不一定代表
     * i-1时的最大利润，可能是更前面的。所以我们可以定义成：
     * dp[i]表示天数为i结尾的连续子数组最大和
     * 2. 状态转移方程
     * dp[i] = dp[i-1] - price[i]
     * 3. 输出
     * 因为目标要求求最大利润,又因为抛出是肯定是要利润较大才抛出，所以问题就是求 min(dp[i-1] - price[i], price[i]))XXX 想法是存在问题的
     * 时间复杂度和空间复杂度都为O(N)
     **/
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        // 定义动态规划方程
        int[][] dp = new int[prices.length][2];

        // 0：用户手上不持股所能获得的最大利润，特指卖出股票以后的不持股，非指没有进行过任何交易的不持股
        // 1：用户手上持股所能获得的最大利润

        // 注意：因为题目限制只能交易一次，因此状态只可能从 1 到 0，不可能从 0 到 1
        // 状态转移方程：
        // dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
        // dp[i][1] = max(dp[i - 1][1], dp[i-1][0]-prices[i])
        // 其中dp[i-1][0]是不能使用的因为题中只规定能交易一次所以状态不能变换0→1，这里dp[i-1][0]特指不持股今天买入，所以为-prices[i]
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[ i -1][0], dp[i -1][1] + prices[i]);
            dp[i][1] = Math.max(dp [i-1][1], -prices[i]);
        }
        // 那么持有的结果根据状态转移方程就是最后一天状态为0时所得到的收益
        return dp[prices.length - 1][0];
    }

    /**
     * 这种方法更容易去理解
     * 其实就是求最高点和最低点的差值，但是我第一反应的确是该由动态规划去做,但是无奈动态规划真的菜
     **/
    public static int maxProfit1(int[] prices){
        if (prices.length <= 1) return 0;
        // 定义最大和最小收益
        int minBenefit = Integer.MAX_VALUE;
        int maxBenefit = 0;
        for (int price : prices) {
            // 如果收益为负的话，没产生正向增益,更新起点
            if (price - minBenefit < 0) {
                minBenefit = price;
            } //如果今天抛出-买入时花销的收益大于最大收益那么更新最大收益
            else if (price - minBenefit > maxBenefit) {
                maxBenefit = price - minBenefit;
            }
        }
        return maxBenefit;
    }

    /**
     * 套公式:
     *     1. 状态 -> 选择
     **/
    public static int maxProfit2(int[] prices){
        if (prices.length <= 1) return  0;
        //定义状态 i,k,当前状态(0-不持有，1-持有)
        // 因为k是固定的只有1次所以这里省去了交易次数k
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0){
                dp[i][0] = 0;
                /**
                 * 解释 dp[0][0] = max(dp[-1][0] , dp[-1][1] + prices[i])
                 * -1不持有状态收益肯定为0
                 * dp[-1][0] = 0
                 * -1抛出股票,属于异常操作,因为-1超出了合理天数 定义
                 * dp[-1][1] = Integer.MIN_VALUE;所以为0
                 **/
                dp[i][1] = -prices[i];
                /**
                 * 解释 dp[0][1] = max(dp[-1][1] , dp[-1][0] - prices[i])
                 * 表示第0天持有股票的收益: max(可能为上一天持有股票收益, 今天买入股票收益)
                 * -1不持有状态收益肯定为0
                 * dp[-1][0] = 0
                 * -1抛出股票,属于异常操作,因为-1超出了合理天数 定义
                 * dp[-1][1] = Integer.MIN_VALUE;所以为0
                 **/
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],  - prices[i]);
        }
        // 最后一天非持有股票的收益肯定为最大值
        return dp[prices.length -1 ][0];
    }
    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{10,2,9,1,2,1,3,1}));
    }
}
