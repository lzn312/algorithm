package leetcode.top100.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * https://leetcode-cn.com/problems/two-sum/
 **/

public class _1_两数之和 {

    /**
     * 这题刷过,可以使时间复杂度控制在O(n) 空间复杂度控制在O(1)
     * 这题就是单纯的实现逻辑，不涉及使用什么算法
     * 使用hashMap完成
     **/
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> resultMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])){
                return new int[]{i, resultMap.get( target - nums[i])};
            }
            resultMap.put(nums[i],i);
        }

        return null;
    }
}
