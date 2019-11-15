package leetcode.top100.simple;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * https://leetcode-cn.com/problems/move-zeroes
 **/
public class _283_移动零 {
    /**
     * 必须在原数组上操作且效率要高 我第一个想到的是用选择排序来做
     * 当元素不为0的时候插入末尾往前移动
     **/
    public static void moveZeroes(int[] nums) {
        if (nums.length >=1){
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0){
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] =  temp ;
                    index++;
                }
            }
        }
    }


    public static void main(String[] args) {
        int nums[] = new int[]{0,1,0,2,3,0,4,8,3,5};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
