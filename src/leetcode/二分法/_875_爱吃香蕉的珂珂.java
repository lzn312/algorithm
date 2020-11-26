package leetcode.二分法;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 *珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例 2：
 *
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例 3：
 *
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *  
 *
 * 提示：
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 **/
public class _875_爱吃香蕉的珂珂 {



    /**
     * 这题我不会，但是可以使用二分法，我们可以从二分法上面入手，
     * 一般二分法的步骤都是:
     *     1. 预处理（排序）
     *     2. 二分查找
     *     3. 后置处理
     * 总结一下一般实现的几个条件：
     *
     *
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid +1
     *
     * 这一题其实就是找最小能满足H次的值(向上取整是多少，以前没有这种想法要往这一块想) 现在有了。
     * 如果我们按照这一块的想法去搞，我们可以定位我们最小的速度是1，因为它肯定不会从0开始吃了嘛，那就成了傻逼逼了，然后最大速率也就是数组最大值，
     * 因为不然你吃再多，都要休息，只能吃一堆。那样的话这一题就可以转换成求 1到maxVal之间的最值，就转换成二分查找了
     **/
    public int minEatingSpeed(int[] piles, int H) {
        int maxVal  = IntStream.of(piles).max().orElse(1);

        // 定义左右节点
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = (right  + left) >> 1;
            // 如果在这个时间段内能吃完，那就缩小最大值范围
            if (canEat(mid, H, piles)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        // 当缩小到left >= right 的那个时，那说明已经确认了哪一个点了，这点就是最小速率了。
        return left;

    }

    private boolean canEat(int speed, int h, int[] piles) {
        int sum = 0;
        for (int pile : piles) {
            sum += Math.ceil( pile * 1.0 / speed );
        }
        return sum <= h;
    }

    public static void main(String[] args) {
        _875_爱吃香蕉的珂珂  test = new _875_爱吃香蕉的珂珂();
        System.out.println(test.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}
