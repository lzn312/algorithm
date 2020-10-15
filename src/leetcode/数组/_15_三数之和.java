package leetcode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Leezer
 * @date 2020/10/15 9:54 上午
 *
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 **/
public class _15_三数之和 {

    /**
     * 这题和简单的两数之和是类似的题，但是做法可以换一下。
     * 他的目标为两个:
     *     1. 答案不能包含重复的三元组
     *     2. 三元组之和为0
     *
     * 我们的思路是： 我们可以固定一个元素，然后使用双指针移动的形式去做，但是双指针移动的前提为数组必须有序。
     * 如果固定元素比0大，双指针的位置位于它后面，是不可能为0的，直接可以跳过，如果是和大于0了，移动right指针位置，如果和小于0了，移动left指针。
     * 期间还要注意判重。
     **/
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }

        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int minNum = nums[i];
            int left = i+1;
            int right = nums.length - 1;

            if (minNum > 0) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (left < right) {
                    int result = minNum + nums[left] + nums[right];
                    if (result > 0) {

                        right--;
                    } else if (result < 0) {

                        left++;
                    }else {
                        List<Integer> threeNumTuple = new ArrayList<>(3);
                        threeNumTuple.add(minNum);
                        threeNumTuple.add(nums[left]);
                        threeNumTuple.add(nums[right]);
                        results.add(threeNumTuple);
                        while ( left < right &&  nums[left] == nums[left + 1] ){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }

        }
        return results;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

}
