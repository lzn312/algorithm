package leetcode.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 **/
public class _62_不同路径 {

    int m;
    int n;

    int count = 0;
    public int uniquePaths(int m, int n) {
        this.m = m-1 ;
        this.n = n - 1;

        List<Integer> res = new ArrayList<>();
        backtrack(res, 0, 0);
        return count;
    }


    public int uniquePaths1(int m, int n) {

            int[] cur = new int[n];
            Arrays.fill(cur,1);
            for (int i = 1; i < m;i++){
                for (int j = 1; j < n; j++){
                    cur[j] += cur[j-1] ;
                }
            }
            return cur[n-1];
    }

    private void backtrack(List<Integer> res, int row, int column) {
        if (row > m || column > n) {
            return;
        }
        if (row == m && column == n) {
          count++;

        }
        backtrack(res, row+1, column);
        backtrack(res, row, column+1);


    }

    public static void main(String[] args) {
        _62_不同路径 test = new _62_不同路径();
//        System.out.println(test.uniquePaths(3,2));
        System.out.println(test.uniquePaths1(2,3));
        System.out.println(test.uniquePaths1(3,7));
    }
}
