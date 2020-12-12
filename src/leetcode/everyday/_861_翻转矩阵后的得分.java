package leetcode.everyday;

/**
 *
 **/
public class _861_翻转矩阵后的得分 {


    /**
     * 这一题，其实问题就在于，我们需要尽可能多的1，而因为1是按二进制进行计算的，所以我们需要高位尽可能都为1.
     * 而其余的列，则是在0，1之间选取最大个数的，转换为1，就行了。
     **/
    public static int matrixScore(int[][] A) {

        if (A.length == 0 )
            return 0;
        // 我们先把每一行的第一位置位1，则一定是至多的数,我们可以默认第一位都为1
        int result = A.length * (1<<(A[0].length - 1 ));
        // 我们统计出来每一列的0和1个数，最大的相加就是其最大值
        for (int i = 1; i < A[0].length; i++) {
            int count = 0;

            for (int j = 0; j < A.length; j++) {
                // 这里有一个取巧的地方，如果第j行当前的列，如果它为0，得它和第一位是否相等。如果相等，如果第一行是0，则会做过异或，转移了。也要算一的个数
                if (A[j][i] == A[j][0]) {
                    count++;
                }
            }
            // 取出0和1的个数最大值 * 该为的原始值
            result += Math.max(count, A.length - count) * (1<<(A[0].length - 1 - i));
        }
        return result;
    }

    // 改变原数组解法
    public static int matrixScore1(int[][] A) {

        if (A.length == 0 )
            return 0;

        for (int row = 0; row < A.length; row++) {
            if (A[row][0] == 0){
                for (int i = 0; i < A[row].length; i++) {
                    A[row][i] ^= 1;
                }
            }
        }




        // 我们先把每一行的第一位置位1，则一定是至多的数,我们可以默认第一位都为1
        int result = A.length * (1<<(A[0].length - 1 ));
        // 我们统计出来每一列的0和1个数，最大的相加就是其最大值
        for (int i = 1; i < A[0].length; i++) {
            int count = 0;

            for (int[] ints : A) {
                if (ints[i] == 1) {
                    count++;
                }
            }
            // 取出0和1的个数最大值 * 该为的原始值
            result += Math.max(count, A.length - count) * (1<<(A[0].length - 1 - i));
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] asp = new int[3][3];
        asp[0] = new int[]{0,0,1,1};
        asp[1] = new int[]{1,0,1,0};
        asp[2] = new int[]{1,1,0,0};

        System.out.println(matrixScore(asp));
        System.out.println(matrixScore1(asp));

    }
}
