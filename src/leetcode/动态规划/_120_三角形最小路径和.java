package leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 *  
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 **/
public class _120_三角形最小路径和 {

    public static int minimumTotal_not_suc(List<List<Integer>> triangle) {
        // 边界值判定
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }


        // 定义动态数组: 对于第 i 行结尾的最小路径的下标
        int[] dp = new int[triangle.size()];

        dp[0] = 0;


        for (int i = 1; i < triangle.size(); i++) {

            // 比较本次lu'jing路径下标的值
            List<Integer> rowList = triangle.get(i);

            // 获取上一个的最小路径下标。
            int minPrevIndex = dp[i - 1];

            Integer leftVal = rowList.get(minPrevIndex);
            // 不用判断minPrevIndex +1 是否超出下标因为 下一行绝对比上一行的数据多1
            Integer rightVal = rowList.get(minPrevIndex + 1);
            if (leftVal <= rightVal) {
                dp[i] = minPrevIndex;
            } else if (leftVal > rightVal) {
                dp[i] = minPrevIndex + 1;
            }
//            else {
//                // 如果相等
//            }
        }

        int res = triangle.get(0).get(dp[0]);
        for (int i = 1; i < dp.length; i++) {
            res += triangle.get(i).get(dp[i]);
        }
        return res;
    }


    public static int minimumTotal(List<List<Integer>> triangle) {
        // 边界值判定
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }


        // 定义动态数组: 表示第【i】行第 j个元素时 的最小值
        int[][] dp = new int[triangle.size()][triangle.size()];

        // 定义初始条件
        dp[0]= new int[]{triangle.get(0).get(0)};


        for (int i = 1; i < triangle.size(); i++) {
            // 每一个起始位置都能直接赋值
            dp[i] = new int[triangle.get(i).size()];
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);

            // 该层每一个下标的最小值是上层节点的最小值 + 本层的值
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min( dp[i -1 ][j] , dp[i-1][j-1]) + triangle.get(i).get(j);
            }
            // 尾值也是固定值
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }


        int  res = dp[triangle.size() -1][0];
        for (int i = 1; i < triangle.size(); i++) {
            res = Math.min(res, dp[triangle.size() - 1][i]);
        }


        return res;
    }


    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(5, 6, 7));
        triangle.add(Arrays.asList(4, 2, 8, 3));

        System.out.println(minimumTotal(triangle));
//        System.out.println(minimumTotal_not_suc(triangle));
    }
}
