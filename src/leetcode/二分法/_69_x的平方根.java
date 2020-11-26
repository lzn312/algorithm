package leetcode.二分法;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 **/
public class _69_x的平方根 {

    /**
     * 这个用二分法来做是比较经典的，我们需要二分的数组就是从0到x内，
     * 如果满足其条件就返回，不满足就返回最后的结果
     **/
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 确定边界条件
        long  left = 1;
        long  right  = x /2  ;

        while (left < right) {
            long mid = ((right + left ) >> 1) + 1;
            if (mid > x / mid) {
                right = mid - 1;
            }else {
                left = mid;
            }

        }
        return (int) left;
    }

    public static void main(String[] args) {
        _69_x的平方根  test = new _69_x的平方根();
        System.out.println(test.mySqrt(8));
        System.out.println(test.mySqrt(6));
    }
}
