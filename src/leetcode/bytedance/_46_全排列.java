package leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *

 **/
public class _46_全排列 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        innerPermute(nums, new HashSet<>(), res, new ArrayList<>());
        return res;
    }

    private void innerPermute(int[] nums, Set<Integer> used, List<List<Integer>> res, List<Integer> curRes) {

            if (curRes.size() == nums.length){
                res.add(new ArrayList<>(curRes));
                return;
            }


            for (int num : nums) {
                if (!used.contains(num)){
                    used.add(num);
                    curRes.add(num);
                    innerPermute(nums, used, res, curRes);

                    used.remove(num);
                    curRes.remove(curRes.size() -1);

                }
            }


    }


}
