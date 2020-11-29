package leetcode.位运算;

/**
 * @author Leezer
 * @date 2020/11/20 1:12 下午
 **/
public class _191_位1的个数 {

    /**
     * 这题可以通过和1做与运算，如果结果> 0那说明此位置有值。
     * 而对于java来说，int 为32位。所以我们需要轮询32次，使其做与运算
     **/
    public int hammingWeight1(int n) {

        int result = 0;
        // 定义一个标记掩码位
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                result++;
            }
            mask = mask << 1;
        }
        return result;

    }


    /**
     * 这题可以通过和1做与运算，如果结果> 0那说明此位置有值。
     * 而对于java来说，int 为32位。所以我们需要轮询32次，使其做与运算
     * 但是上述无论我们的数多大，我们都还要去循环32次，我们这次考虑一下
     * 使用 n & n-1的值，永远是n-1；这种情况下如果它小于0了，说明轮询完了。
     * 并且 n & n-1都表示低位为0；
     **/
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            n &= n -1;
            ++count;
        }
        return count;

    }
}
