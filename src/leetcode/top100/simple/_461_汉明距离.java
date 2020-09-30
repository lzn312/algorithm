package leetcode.top100.simple;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * https://leetcode-cn.com/problems/hamming-distance
 **/
public class _461_汉明距离 {
    /**
     * 用到了异或运算的性质
     * 1^1 = 0
     * 0^0 = 0
     * 1^0 = 1
     * 最后转变为求1的个数
     **/
    public int hammingDistance(int x, int y) {
        // bitCount输出1的个数
        return Integer.bitCount(x^y);

    }

    public static void main(String[] args) {
        _461_汉明距离 test = new _461_汉明距离();
        System.out.println(test.hammingDistance(1,10));
    }
}
