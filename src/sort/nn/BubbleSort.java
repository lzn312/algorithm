package sort.nn;
/**
 * 冒泡排序
 * 最好时间复杂度O(n)
 * 最坏时间度O(n^2)
 * 平均时间复杂度O(n2)
 * 是否稳定-> 稳定
 **/
public class BubbleSort {

    public int[] sort(int[] nums){
        if (nums.length <= 1) return nums;
        // 冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j< nums.length - i -1 ; j++){
                if (nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

}
