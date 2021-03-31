package leetcode.深度及广度优先;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *  
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 *
 * 示例 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 *
 *  
 *
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 *
 **/
public class _695_岛屿的最大面积 {


    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        Queue<int[]> buffer = new LinkedList<>();
        for (int column = 0; column < grid.length ; column++) {
            for (int row = 0; row < grid[column].length; row++) {
                buffer.add(new int[]{column, row});
                res = Math.max(res, fillArea( grid, buffer));
            }
        }

        return res;

    }

    private int fillArea( int[][] grid, Queue<int[]> buffer) {
        int res = 0;

        while (!buffer.isEmpty()){
            int[] tuple = buffer.poll();
            int column = tuple[0];
            int row = tuple[1];

            if (column >= 0 && column < grid.length &&
                    row >= 0 && row < grid[column].length
                    && grid[column][row] == 1) {
                res++;
                grid[column][row] = 0;
                buffer.add(new int[]{column - 1, row});
                buffer.add(new int[]{column + 1, row});
                buffer.add(new int[]{column, row + 1});
                buffer.add(new int[]{column, row - 1});
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _695_岛屿的最大面积 test = new _695_岛屿的最大面积();
        int[][] grid = new int[8][13];

        grid[0] = new int[]{0,0,1,0,0,0,0,1,0,0,0,0,0};
        grid[1] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        grid[2] = new int[]{0,1,1,0,1,0,0,0,0,0,0,0,0};
        grid[3] = new int[]{0,1,0,0,1,1,0,0,1,0,1,0,0};
        grid[4] = new int[]{0,1,0,0,1,1,0,0,1,1,1,0,0};
        grid[5] = new int[]{0,0,0,0,0,0,0,0,0,0,1,0,0};
        grid[6] = new int[]{0,0,0,0,0,0,0,1,1,1,0,0,0};
        grid[7] = new int[]{0,0,0,0,0,0,0,1,1,0,0,0,0};

        System.out.println(test.maxAreaOfIsland(grid));
    }
}
