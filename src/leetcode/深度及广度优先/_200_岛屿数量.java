package leetcode.深度及广度优先;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 **/
public class _200_岛屿数量 {

    // 这题可以用广度优先的方式来进行处理
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }


        // 记录岛屿数量
        int res = 0;
        Queue<int[]> buffQueue = new LinkedList<>();
        for (int column = 0; column < grid.length; column++) {
            for (int row = 0; row < grid[column].length; row++) {
                if (grid[column][row] == '1') {
                    fillIsland(buffQueue, column, row, grid);
                    res++;
                }

            }
        }

        return res;
    }

    private void fillIsland(Queue<int[]> buffQueue, int column, int row, char[][] grid) {
        buffQueue.add(new int[]{column, row});

        // 进行沉岛操作
        while (!buffQueue.isEmpty()){

            int[] indexTuples = buffQueue.poll();

            column = indexTuples[0];
            row = indexTuples[1];
            if (column >= 0 && column < grid.length
                    && row >=0 && row<grid[0].length
                    && grid[column][row] == '1'){
                // 进行沉岛操作
                grid[indexTuples[0]][indexTuples[1]] = '0';

                // 添加其空间组元素
                buffQueue.offer(new int[]{column -1, row});
                buffQueue.offer(new int[]{column + 1, row});
                buffQueue.offer(new int[]{column , row + 1});
                buffQueue.offer(new int[]{column , row -1});
            }

        }

    }


    public static void main(String[] args) {

    }
}
