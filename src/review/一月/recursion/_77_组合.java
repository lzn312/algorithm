package review.一月.recursion;

import java.util.ArrayList;
import java.util.List;

public class _77_组合 {

    // 回溯来做这一题
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 ){
            return res;
        }

//        dfs(n,k,1,res, new ArrayList<>());
        backtrack(n,k,1,res, new ArrayList<>());
        return res;

    }

    private void backtrack(int maxSize, int combineSize, int level, List<List<Integer>> res, List<Integer> currAres) {
        // terminator
        if (currAres.size() == combineSize) {
            res.add(new ArrayList<>(currAres));
            return;
        }


        for (int begin = level; begin <= maxSize; begin++) {
            currAres.add(begin);
            backtrack(maxSize, combineSize, begin + 1, res, currAres);
            currAres.remove(currAres.size() - 1);
        }
    }

    private void dfs(int maxSize, int combineSize, int level, List<List<Integer>> res, List<Integer> currAres) {
        // terminator
        if (currAres.size() == combineSize) {
            res.add(new ArrayList<>(currAres));
            return;
        }
        if (level > maxSize) {
            return;
        }


        // process 要么直接跳过该元素，要么添加该元素 跳过该元素
        dfs(maxSize, combineSize, level + 1, res, currAres);
        // 使用该元素
        currAres.add(level);
        dfs(maxSize, combineSize, level + 1, res, currAres);

        //backtrack
        currAres.remove(currAres.size() -1 );

    }

    public static void main(String[] args) {
        _77_组合 test = new _77_组合();
        System.out.println(test.combine(4,2));
    }

}
