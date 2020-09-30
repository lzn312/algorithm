package sort.nn;

import java.util.Arrays;

/**
 * 插入排序
 * 最好时间复杂度O(n)
 * 最坏时间度O(n^2)
 * 平均时间复杂度O(n2)
 * 是否稳定-> 稳定
 **/

public class InsertSort {
    public int[] sort(int[] nums){
        if (nums.length <= 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            // 选择未排序值
            int value = nums[i];
            // 该空间前1就是排序的控件
            int j = i -1;
            // 和在已排序的空间进行比较
            for (;j>=0;j--){
                if (nums[j] > value){
                    // 如果数据比他大就要留位置给它
                    nums[j+1] = nums[j];
                    // 运行到这就经历了j--;
                }else {
                    break;
                }
            }
            // 因为跳出循环之后j就是已排序空间中比他小的那个下标,所以要j+1插入进去 所以这里的j +1 其实就是 (j--)+1 = j
            nums[j+1] = value;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,7,1,2,9,4};
        InsertSort selectSort = new InsertSort();
        System.out.println(Arrays.toString(selectSort.sort(nums)));
    }
}
