package review.一月.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _47_FullCombineII {

    // 这一题是变种，直接使用存储下标的形式就可以
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        backTrack(nums, res, new HashSet<>(nums.length),  new ArrayList<>());
        return res;

    }

    private void backTrack(int[] nums, List<List<Integer>> res, Set<Integer> usedIndex, List<Integer> curr) {
        if (curr.size() == nums.length) {

                res.add(new ArrayList<>(curr));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && usedIndex.contains(i-1)){
                continue;
            }
            if (!usedIndex.contains(i) ) {
                // 表明这次变量已经使用了
                usedIndex.add(i);
                curr.add(nums[i]);
                backTrack(nums, res, usedIndex, curr);

                // 使用完成后需要移除这一次变量的使用标识
                usedIndex.remove(i);
                curr.remove(curr.size() - 1);
            }

        }

    }

    public static void main(String[] args) {
        _47_FullCombineII test = new _47_FullCombineII();
        System.out.println(test.permuteUnique(new int[]{1, 1, 2}));
    }
}
