package leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 **/
public class _54_螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {

        int x =0;
        int y =0;
        int up = 0;
        int left = 0;
        int down = matrix.length -1;
        int right = matrix[0].length -1;

        List<Integer> res = new ArrayList<>();

        while (left <= right && up <= down) {


            for (y = left; y <= right && avoid(left, right, up, down); y++) {
                res.add(matrix[x][y]);
            }
            y--;
            up++;

            for (x = up; x <= down && avoid(left, right, up, down); x++) {
                res.add(matrix[x][y]);
            }
            x--;
            right--;



            for (y = right; y >= left && avoid(left, right, up, down); y--) {
                res.add(matrix[x][y]);
            }
            y++;
            down--;


            for (x = down; x >= up && avoid(left, right, up, down); x--) {
                res.add(matrix[x][y]);
            }
            x++;
            left++;

        }


        return res;



    }


    private boolean avoid(int left,int right ,int up, int down) {
        return left <= right && up <= down;
    }


    public static void main(String[] args) {
        _54_螺旋矩阵 test = new _54_螺旋矩阵();
        int[][] ac = new int[3][3];
        ac[0] = new int[]{1,2,3};
        ac[1] = new int[]{4,5,6};
        ac[2] = new int[]{7,8,9};
        System.out.println(test.spiralOrder(ac));
    }

}
