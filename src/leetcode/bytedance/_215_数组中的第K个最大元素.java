package leetcode.bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 **/
public class _215_数组中的第K个最大元素 {


    public static  int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();


        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }


    public static  int find2thLargest(int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < nums.length; i++) {
            queue.add(new int[]{nums[i], i});
            if (queue.size() > 2) {
                queue.poll();
            }
        }
        return queue.peek()[1];
    }

    public static void main(String[] args) {
        _215_数组中的第K个最大元素 test = new _215_数组中的第K个最大元素();
        System.out.println(test.findKthLargest(new int[]{3, 2, 1, 4, 5, 6}, 2));
        System.out.println(test.find2thLargest(new int[]{3, 2, 1, 4, 5, 6}));
    }
}
