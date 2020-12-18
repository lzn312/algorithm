package leetcode.top100.middle;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 * 通过次数92,340提交次数215,363
 **/
public class _240_搜索二维矩阵II {

    /**
     * 这题我觉得可以使用二分查找来做，逐行二分
     **/
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0){
            return false;
        }
        int columnIndex = 0;
        while (columnIndex <= matrix.length -1){
            if (matrix[columnIndex][0] > target){
                break;
            }
            int rowLeft = 0;
            int rowRight = matrix[0].length -1 ;
            while (rowLeft <= rowRight){
                int mid = rowLeft + ((rowRight - rowLeft ) >> 1);
                if (matrix[columnIndex][mid] == target){
                    return true;
                }else if (matrix[columnIndex][mid] > target){
                    rowRight = mid -1;
                }else {
                    rowLeft = mid + 1;
                }
            }

            columnIndex++;
        }
        return false;
    }


    public static void main(String[] args) {

        _240_搜索二维矩阵II test = new _240_搜索二维矩阵II();
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,4,7,11,15};
        matrix[1] = new int[]{2,5,8,12,19};
        matrix[2] = new int[]{3,6,9,16,22};
        matrix[3] = new int[]{10,13,14,17,24};
        matrix[4] = new int[]{18,21,23,26,30};


//        System.out.println(test.searchMatrix(matrix, 5));
//        System.out.println(test.searchMatrix(matrix, 31));
//        System.out.println(test.searchMatrix(new int[][]{{-5}}, -5));
//        System.out.println(test.searchMatrix(new int[][]{{-1,3}}, 3));
//        System.out.println(test.searchMatrix(new int[][]{{-1},{-1}}, 0));
        System.out.println(test.searchMatrix(new int[][]{{1,3,5}}, 3));
    }
}
