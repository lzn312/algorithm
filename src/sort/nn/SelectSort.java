package sort.nn;

import java.util.Arrays;

/**
 * 选择排序
 * 思想:
 *     选取未排序空间移动到排序空间末尾
 * 最好时间复杂度O(n^2)
 * 最坏时间度O(n^2)
 * 平均时间复杂度O(n^2)
 * 是否稳定-> 稳定
 **/
public class SelectSort {
    public int[] sort(int[] nums){
        if (nums.length <= 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            // 确定 未排序边界
            int min = i;
            for (int j = i+ 1; j < nums.length;j++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            if (i != min){
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,1,2,9,4};
        SelectSort selectSort = new SelectSort();
        System.out.println(Arrays.toString(selectSort.sort(nums)));
    }
}
