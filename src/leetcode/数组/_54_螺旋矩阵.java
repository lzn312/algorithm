package leetcode.数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 **/
public class _54_螺旋矩阵 {

    /**
     * 螺旋矩阵的题，主要有几方面需要想想，
     * 第一个: 边界值的确定。
     * 第二个： 界限的转换
     * 我们定义四个值来表示它的界限: up/down/left/right； x,y代表他的第x行，第y列。
     * 首先我们沿着左往右走，走到头说明up遍历完了，这个时候，up++.接着我们要往下遍历， 遍历完成后，right--。表示这一列已经遍历完了。
     * 接着往左走，走到头了。down--；接着往上走。left++；直至遍历完成。
     **/
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, left = 0;
        int x = 0 ,y=0;
        int right = matrix[0].length -1 ;
        int down = matrix.length -1 ;

        List<Integer> res = new ArrayList<>();
        while (left <= right && up <= down) {
            // 先往右走
            for (y = left; y <= right && avoid(up,down,left, right); y++) {
                res.add(matrix[x][y]);
            }
            // 因为运行到最终步骤后y还会做 y++ 会超出下标，所以需要--
            y--;
            up++;
            // 往下走
            for (x = up; x <= down  && avoid(up,down,left, right); x++) {
                res.add(matrix[x][y]);
            }
            x--;
            right--;

            // 往左走
            for (y = right; y >= left  && avoid(up,down,left, right) ; y--) {
                res.add(matrix[x][y]);
            }
            y++;
            down--;

            // 往上走
            for (x = down; x >= up  && avoid(up,down,left, right) ; x--) {
                res.add(matrix[x][y]);
            }
            x++;
            left++;
        }
        return res;
    }

    private boolean avoid(int up, int down, int left, int right) {
        return up <= down && left <= right;
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
