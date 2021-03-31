package leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 **/
public class _15_三数之和 {



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 ) return res;

        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            int sentinelVal = nums[i];

            int left = i + 1;
            int right = nums.length -1;

            if (sentinelVal > 0) {
                break;
            }
            if (i == 0 || nums[i] != nums[i - 1]) {
                while(left < right) {
                    int result = sentinelVal + nums[left] + nums[right];
                    if (result == 0) {
                        List<Integer> curRes = new ArrayList<>(3);
                        curRes.add(sentinelVal);
                        curRes.add(nums[left]);
                        curRes.add(nums[right]);
                        res.add(curRes);
                        while(left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    }else if (result > 0) {
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;

    }
}
