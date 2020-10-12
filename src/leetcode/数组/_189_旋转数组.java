package leetcode.数组;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 **/
public class _189_旋转数组 {


    /**
     * 使用环状替换
     **/
    static void rotate1(int[] nums, int k) {

    }


    /**
     * 通过反转的形式得到最终的结果，
     * 我们的思路时先把整个数组进行反转，再把 前 k个数进行反转，再把 n-k个数进行反转后就能得到我们想要的结果。
     * 因为我们最终反转了3此，所以时间复杂度时O(n)
     * 空间复杂度时O(1)
     **/
    static void rotate2(int[] nums, int k) {
        if (nums.length < k) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length -1);
    }

     static void reverse(int[] nums, int start, int end) {
         while (start < end) {
             int temp = nums[start];
             nums[start] = nums[end];
             nums[end] = temp;
             start++;
             end--;
         }
    }


    /**
     * 这题比较烦的就是，要求时原地算法。不然能变得很简单，使用插入排序类似的思想就能搞定。
     **/
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate2(nums, k);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {-1,-100,3,99};
        int k1 = 2;
        rotate2(nums2, k1);
        System.out.println(Arrays.toString(nums2));
    }
}
