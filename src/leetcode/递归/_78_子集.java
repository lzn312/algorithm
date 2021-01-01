package leetcode.递归;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 **/
public class _78_子集 {

    /**
     * 这题其实也是最近重复子集问题，递归可以做，我们分解到当前元素，
     * 就是可以选择或者不进行选择。
     **/
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(Collections.singletonList(nums[0]));
            return res;
        }

        innerSubsets(0,  nums, new ArrayList<>(), res);

        return res;
    }

    private void innerSubsets(int index, int[] nums, List<Integer> currRes, List<List<Integer>> res) {


        // terminator
        if ( index == nums.length) {
            res.add(new ArrayList<>(currRes));
            return;
        }


        innerSubsets(index + 1, nums, currRes, res);
        currRes.add(nums[index]);
        innerSubsets(index + 1, nums, currRes, res);


        currRes.remove(currRes.size() - 1);
    }


    public static void main(String[] args) {
        _78_子集 v = new _78_子集();

        System.out.println(v.subsets(new int[]{1, 2, 3}));
    }

}
