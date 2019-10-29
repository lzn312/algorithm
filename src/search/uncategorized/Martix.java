package search.uncategorized;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 目标思路:
 * 因为自上而下、从左到右都是有序的
 * 我们选取左下角的数值开始进行比较
 * 如果当前目标数值比当前值二维数组具体值大 那么向上数值都抛弃 因为都比当前值小
 * 如果当前目标数值比当前值二维数组具体值小 那么向左数值都抛弃 因为都比当前值小
 **/
public class Martix {


    /**
     * @param matrix 二维数组
     * @param target 目标数值
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     **/
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }else{
            int j = matrix.length - 1;
            for(int k = 0; k<= j; k++){
                for(int l = 0; l< matrix[0].length; l++){
                    if(matrix[k][l]  > target){
                        break;
                    }else  if(matrix[k][l] == target){
                        return true;
                    }
                }
            }
            return  false;
        }
    }



    /**
     * @param matrix 二维数组
     * @param target 目标数值
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     **/
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        } else {
            int j = matrix.length - 1;
            int i = 0;
            while (i < matrix[0].length && j >= 0) {
                if (matrix[j][i] > target) {
                    j--;
                } else if (matrix[j][i] < target) {
                    i++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

}
