package leetcode.string;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 **/
public class _剑指Offer_17_打印从1到最大的n位数 {



    /**
     * 这题没啥难度，就是找到10^n次方，然后得到最大数，返回即可。
     **/
    public int[] printNumbers(int n) {
        if (n < 1) {
            return new int[]{-1};
        }
        int pow = (int)Math.pow(10, n);
        int[] res = new int[pow -1];
        for (int i = 1; i < pow; i++) {
            res[i] = i;
        }
        return res;
    }
}
