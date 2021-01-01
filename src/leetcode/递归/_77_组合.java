package leetcode.递归;

import java.util.ArrayList;
import java.util.List;

/**
 * 定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]

 **/
public class _77_组合 {


    /**
     * 组合问题可以使用回溯来解决这个问题，回溯的本质其实就是递归的一种体现，来解决这个问题。
     * n -> k-> 边界
     **/
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1) {
            return null;
        }

        innerCombine(1, n, k, new ArrayList<>(), res);

        return res;
    }

    private void innerCombine(int index, int maxNum, int maxSize, List<Integer> currRes, List<List<Integer>> res) {

        if (index > maxNum ){
            if (currRes.size() == maxSize) {
                res.add(new ArrayList<>(currRes));
            }
            return;
        }


        // terminator
        if (currRes.size() == maxSize){
            res.add(new ArrayList<>(currRes));
            return;
        }

        // process， not pick current 元素
        innerCombine(index + 1, maxNum, maxSize, currRes, res);

        // pick current 元素
        currRes.add(index);

        innerCombine(index+1, maxNum,maxSize,currRes, res);

        // reverse 需要把当前元素移除
        currRes.remove( currRes.size() - 1 );
    }

    public static void main(String[] args) {
        _77_组合 test = new _77_组合();
        System.out.println(test.combine(4, 2));
    }
}
