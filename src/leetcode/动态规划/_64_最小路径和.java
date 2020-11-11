package leetcode.动态规划;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 **/
public class _64_最小路径和 {
    /**
     * 这题和三角形的最小路径和大概想法是一致的。唯一的区别的，三角形的最小路径和是向下移动的，
     * 而最小路径和是向下或者向有移动都行，
     * 我们还是按照模板来：
     * 第一步：
     * 列出状态转移方程 dp[i][j] 代表 第i行第j列的最小路径和,所以我们返回的结果就是dp[i][j]；
     * 那么dp[i][j] 和 上一步骤的关系式就是
     * dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + grid[i][j]
     * 但是我们知道当我们是第一列的时候比较特殊，他不可能通过它的左节点获取到。所以我们得出
     * if(j == 0) dp[i][0] = dp[i-1][0] + grid[i][j]
     * 并且第一行的最小路径和需要单独处理
     * 第二步:
     * 得出起始条件
     * dp[0] = grid[0]
     **/
    public static int minPathSum(int[][] grid) {
        // 判断边界条件
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // 列出dp转移方程
        int[][] dp = new int[grid.length][];
        // 获取起始条件
        dp[0] = new int[grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i] = new int[grid[i].length];
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        int n = grid.length - 1;
        int m = grid[grid.length -1].length - 1;

        return dp[n][m];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[]{1,3,1};
        grid[1] = new int[]{1,5,1};
        grid[2] = new int[]{4,2,1};
        System.out.println(minPathSum(grid));
        int[][] grid1 = new int[2][];
        grid1[0] = new int[]{1,2,5};
        grid1[1] = new int[]{3,2,1};
        System.out.println(minPathSum(grid1));
    }
}
