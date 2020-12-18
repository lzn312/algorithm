package leetcode.top100.middle;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 **/
public class _34_查找位置 {


    /**
     * 这题要求时间复杂度为log n，我们可以用二分查找来实现
     **/
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }


        int[] res = new int[2];

        int start = searchStart(nums, target);
        if (start == -1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }


        int right = searchEnd(nums, target);

        res[0] = start;
        res[1] = right;


        return res;

    }

    private int searchEnd(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int middle = left + ((right - left + 1) >> 1);

            if (nums[middle] == target) {
                left = middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    private int searchStart(int[] nums, int target) {

        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int middle = left + ((right - left ) >> 1);
            if (nums[middle] == target) {
                // 尽可能多的往下寻找
                right =  middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        _34_查找位置 test = new _34_查找位置();
        System.out.println(Arrays.toString(test.searchRange(new int[]{1, 2, 2, 2, 2, 2, 2, 3}, 2)));
    }
}
