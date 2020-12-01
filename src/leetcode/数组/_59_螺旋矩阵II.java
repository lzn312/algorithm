package leetcode.数组;

import java.util.Arrays;

/**
 * @author Leezer
 * @date 2020/12/1 9:56 上午
 **/
public class _59_螺旋矩阵II {


    /**
     * 这题思路和54差不多。一个是读，一个是写
     **/

    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];

        int up=0 ,left = 0;
        int data = 1;
        int right = n -1 , down = n -1;
        int row = 0;
        int column =0;
        while (left <= right && up <= down) {

            for (column = left; column <= right && avoid(up, down, left, right); column++) {
                matrix[row][column] = data++;
            }
            column--;
            up++;

            for (row = up; row <= down && avoid(up, down, left, right); row++) {
                matrix[row][column] = data++;
            }
            row--;
            right--;

            for (column = right; column >= left && avoid(up, down, left, right); column--) {
                matrix[row][column] = data++;
            }

            column++;
            down--;

            for (row = down; row >= up  && avoid(up, down, left, right); row--) {
                matrix[row][column] = data++;
            }

            row++;
            left++;

        }

        return matrix;
    }


    private boolean avoid(int up,int down,int left, int right) {
        return up <= down && left <= right;
    }

    public static void main(String[] args) {

        _59_螺旋矩阵II test = new _59_螺旋矩阵II();
        System.out.println(Arrays.deepToString(test.generateMatrix(3)));
    }
}
