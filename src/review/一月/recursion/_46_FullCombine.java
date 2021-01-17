package review.一月.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _46_FullCombine {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;

        backTrack(nums, res, new HashSet<>(nums.length), new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, Set<Integer> used, List<Integer> curr) {
        // terminator
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!used.contains(num)) {
                // 表明这次变量已经使用了
                used.add(num);
                curr.add(num);
                backTrack(nums, res, used, curr);

                // 使用完成后需要移除这一次变量的使用标识
                used.remove(num);
                curr.remove(curr.size() - 1);
            }

        }


    }

    public static void main(String[] args) {
        _46_FullCombine test = new _46_FullCombine();
        System.out.println(test.permute(new int[]{1,2,3}));
    }
}
