package leetcode.top100.simple;
/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 *
 * 这题我首先想到的是用动态规划来做,但是我不会使用动态规划,所以思路想不出来
 * 我们需要考虑动态规划的步骤来思考这一个问题:
 * 1. 分解成规模最小的问题
 * 2. 列出状态转移方程
 * 3. 看问题的是求什么
 **/
public class _70_爬楼梯 {
    /**
     * 按照上述步骤来分析一下:
     * 1. 分解成最小规模的问题:
     *     对于第i格都可以分解成下列两种情况:
     *         从i-1格迈出1格到第i格
     *         从i-2格迈出2格到第i格
     *         所以到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和。
     *         假设dp[i]代表第i格的所有走法
     * 2. 列出状态转移方程
     *     那么这题就可以定义出状态转移方程对于i格来说dp[i] = dp[i-1] + dp[i-2] 的可能
     * 3. 问题最后结果就是求dp[i
     **/
    public  int climbStairs(int n) {
//        return fibClimbStairs(n);
        return binets(n);
    }

    /**
     * 动态规划求爬楼梯的问题
     * 时间复杂度: 因为是for循环,运行代码与循环条件无关 所以为O(n-3) ->O(n)
     * 空间复杂度: 因为开辟了n的数组 所以空间复杂度为O(n)
     **/
    private static int dpClimbStairs(int n) {
        if (n<4) return n;
        // 因为是求dp[i]前面限定了n>3所以这里可以直接求dp[i]了
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<=n;i++){
            // 求出dp[i]
            dp[i] = dp[i-1] + dp[i-2];
        }
        //结果就是dpn的和
        return dp[n];
    }

    /**
     * 其实转换过后很正常就想到了斐波那契数列,所以这题还可以用斐波那契数列来做
     * 时间复杂度: 因为是for循环,运行代码与循环条件无关 所以为O(n-3) ->O(n)
     * 空间复杂度: O(1)
     **/
    private   int fibClimbStairs(int n){
        if (n<4) return n;
        int first = 1;
        int second = 2;
        for (int i = 3; i<=n;i++){
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    /**
     * ps: 还有一种有趣的方法 但是我不太懂 哈哈
     * Binets 方法 使用矩阵来求解
     * 时间复杂度：O(log(n))
     *
     * 空间复杂度：O(1)，使用常量级空间。
     **/
    public int binets(int n){
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    private int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    private int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }



    public static void main(String[] args) {
//        System.out.println(climbStairs(10));
    }

}
