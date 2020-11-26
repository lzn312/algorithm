package leetcode.位运算;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 *
 *
 **/
public class _231_2的幂 {



    /**
     * 这一题和hashMap的初始化容量很像就是如何找到其长度
     * 我们可以试着做一下,我们可以知道，如果是2的次幂，那么换算成二进制就是高位为1，其-1之后就是高位为0其余都为1;
     * 如果他是偶数，那么它和它-1做与运算其结果就是0，如果是奇数它和它的-1做与运算其结果就不是0了。所以我们通过这个来区分。
     **/
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) > 0;
    }

    public static void main(String[] args) {
        _231_2的幂 test = new _231_2的幂();
//        System.out.println(test.isPowerOfTwo(2));
        System.out.println(test.isPowerOfTwo(1));
//        System.out.println(test.isPowerOfTwo(0));
    }
}
