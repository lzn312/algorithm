package leetcode.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 **/
public class _200_岛屿数量 {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int column = 0; column < grid.length ; column++) {
            for (int row = 0; row < grid[0].length; row++) {
                if (grid[column][row] == '1') {
                    fillIsland(queue, column, row, grid);
                    res++;
                }
            }
        }

        return res;
    }

    private void fillIsland(Queue<int[]> queue, int column, int row, char[][] grid) {

        queue.offer(new int[]{column, row});

        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            column = tuple[0];
            row = tuple[1];

            if (column >= 0
                    && column<grid.length
                    && row >= 0
                    && row < grid[0].length
                    && grid[column][row] == '1') {
                grid[column][row] = '0';
                queue.offer(new int[]{column+1, row});
                queue.offer(new int[]{column-1, row});
                queue.offer(new int[]{column, row-1});
                queue.offer(new int[]{column, row+1});
            }
        }
    }
}
