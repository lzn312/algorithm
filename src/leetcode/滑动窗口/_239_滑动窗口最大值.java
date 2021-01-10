package leetcode.滑动窗口;

import java.util.*;

/**
 *给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 *
 **/
public class _239_滑动窗口最大值 {


    int[] nums ;


    /**
     * 我们可以通过两个指针来做，先找到初始值第一个的滑动窗口最大值，
     * 其实可以用递归来做，但是递归有O(n)的空间复杂度，看一看我们是不是可以直接就完成，
     * 但是我们要注意边界条件的判断，如果k比nums大，我们就只返回一个
     **/
    public  int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }
        if (nums.length == 1 ) {
            return nums;
        }

        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[ nums.length - k + 1];
        int cursor = 0;
        res[cursor++] = nums[0];
        queue.add(nums[0]);
        // 先入队
        for (int i = 1; i < k; i++) {
            res[0] = Math.max(res[0], nums[i]);
            queue.add(nums[i]);
        }


        // 后续只滑动一个值
        for (int i = k; i < nums.length; i++) {
            // 入队比较最大值
            queue.pollFirst();
            int curTemp = nums[i];
            for (Integer next : queue) {
                curTemp = Math.max(curTemp, next);
            }
            queue.add(nums[i]);
            res[cursor++] = curTemp;
        }


        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        _239_滑动窗口最大值 testA = new _239_滑动窗口最大值();
        System.out.println(Arrays.toString(testA.maxSlidingWindow(nums, 3)));
    }


}
