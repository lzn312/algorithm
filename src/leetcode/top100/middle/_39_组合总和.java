package leetcode.top100.middle;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 **/
public class _39_组合总和 {



    /**
     * 这一题典型的回溯题了，我们可以往后面找，找到的数据则看一下尽可能多的能使用几位，
     * 如果没有的话就退一位，然后往后面找。
     **/
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0){
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();

        innerCombinationSum(0, candidates, target, res, new ArrayList<>());

        return res;
    }

    private void innerCombinationSum(int level, int[] candidates, int target, List<List<Integer>> res, List<Integer> currentArray) {

        // terminator
        if ( target < 0){
            return;
        }

        if ( target == 0){
            res.add(new ArrayList<>(currentArray));
            return;
        }
        // process
        for (int i = level; i < candidates.length; i++) {
            // 计算其选择
            int retainTarget = target - candidates[i];

            level = i;

            currentArray.add(candidates[i]);

            innerCombinationSum( level , candidates, retainTarget, res, currentArray);

            // reverse
            currentArray.remove(currentArray.size() - 1);
        }


    }


    public static void main(String[] args) {
        _39_组合总和 test = new _39_组合总和();
        System.out.println(test.combinationSum(new int[]{2,3,6,7}, 7 ));
    }
}
