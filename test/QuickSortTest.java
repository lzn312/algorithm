import util.BaseUtil;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 快排其实核心也是使用了分冶的思想
 * 和归并的区别:
 * 归并排序的处理过程是由下到上的，先处理子问题，然后再合并。
 * 快排正好相反， 它的处理过程是由上到下的，先分区，然后再处理子问题。
 * <p>
 * 平均时间复杂度: O(nlogn)
 * 最好时间复杂度: O(nlogn)
 * 最坏时间复杂度: O(n^2)
 **/
public class QuickSortTest {


    public static void main(String[] args) {
        int[] disorder = BaseUtil.randomIntArray(100, 10);
        QuickSortTest quickSortTest = new QuickSortTest();
        System.out.println(quickSortTest.searchK(disorder,10));
        quickSortTest.quickSort(disorder);
        System.out.println(Arrays.toString(disorder));
    }

    public void quickSort(int[] nums){
        if (nums.length<=1) return;
        quickSortInternally(nums, 0 , nums.length - 1 );
    }

    /**
     * @param start 排序起点
     * @param end 排序尾点
     **/
    private void quickSortInternally(int[] nums, int start, int end) {
        if (start >= end) return;
        // 先分区
        int pivotPoint =  pivot(nums,start, end);
        // 因为pivPoint已经排序好了
        quickSortInternally(nums, start,pivotPoint -1 );
        quickSortInternally(nums, pivotPoint+ 1, end);

    }

    private int pivot(int[] nums, int start, int end) {
        // 排序的下标
        int index = start;
        for (int i = start; i<= end - 1; i++){
            // 这样排序 就能确定左边分区都是小于point的了
            if (nums[i] <= nums[end]){
                // 交换位置
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        // 还需要把point也交换了
        int temp = nums[end];
        nums[end] = nums[index];
        nums[index] = temp;
        return index;
    }


    // 如何在 O(n) 的时间复杂度内查找一个无序数组中的第 K 大元素？
    private int  searchK(int[] nums, int K){
        // 可以用快排的思想进行寻找
        return searchK(nums, 0, nums.length -1 ,nums.length -  K);
    }

    private  int searchK(int[] nums, int start, int end, int K) {
        int p = pivot(nums, start, end );
        //  其实反过来就是求 第num - K 小元素 因为经过p点这个在数组的位置是排序好的确定的 那么就是当排到 p == K说明p点就是最大值K且被排序过了
        if (p == K){
            return nums[p];
        }else if (p  < K){
            return searchK(nums,p+1, end, K);
        } else {
            return searchK(nums, start, p -1, K);
        }
    }


}
