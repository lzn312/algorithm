package leetcode.top100.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 **/
public class _448_找到所有数组中消失的数字 {

    /**
     * 这题难度就在于要求空间复杂度为O(1)
     * XXX 我是没什么想法,真的没想出来怎么做
     * 这题要使用的是鸽巢原理又称抽屉原理来做:
     *     假设现在有n个巢,n+1只鸽子,那么至少有两只鸽子在一个巢内
     * 这题另外一个关键点就是如何把正确的数(n)放到正确的巢里(index)，如果在正确的巢内没存放正确的数据那么该数据就是消失的数据
     * 因为不能使用额外的数组空间,只能使用交换数据来做
     * 交换数据可以使用异或来做: 即交换a1、a2
     * 那么具体步骤就是
     *     a1 = a1^a2;
     *     a2 = a2^a1;
     *     a1 = a1^a2;
     **/
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // 定义返回结果
        List<Integer> disappearedNumbers = new ArrayList<>();
        // 先进行占巢操作
        for (int i = 0; i < nums.length; i++) {
            // 既定 nums[i]是正确的鸽子 那么 nums[i] -1 就是正确的巢穴
           /* int nest = nums[i] -1; -- 不能开始定义死了这个值因为后面nums[i]值会变 且额外使用了一个空间
            while (nums[i] != nums[nest]){
                swap(nums, i, nest);
            }*/
           while (nums[i] != nums[ nums[i] - 1]){
               swap(nums, i , nums[i] -1 );
           }
        }
        // 那么现在可以找找还站着不对巢的鸽子了
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1){
                disappearedNumbers.add(i+1);
            }
        }
        return disappearedNumbers;
    }
    private static void swap(int[] nums, int index, int nest){
        // 如果两个相等,说明已经放入正确巢穴了
        System.out.println(String.format("Change index: (%s,value:%s) into nest: (%s,value:%s) ", index, nums[index], nest, nums[nest]));
        if (index == nest){
            return;
        }
        // 开始交换
        nums[index] = nums[index] ^ nums[nest];
        nums[nest] = nums[index] ^ nums[nest];
        nums[index] = nums[index] ^ nums[nest];
        System.out.println(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,3,2,7,8,2,3,1};
        List<Integer> result = findDisappearedNumbers(nums);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
