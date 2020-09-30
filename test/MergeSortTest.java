import com.sun.org.apache.xerces.internal.xs.ItemPSVI;
import util.BaseUtil;

import java.util.Arrays;

/**
 * 归并排序
 * 其实大致思路就是划分区域到最小堆进行排序.那么久能确保在这个区域内的
 **/
public class MergeSortTest {



    public static void main(String[] args) {
        int[] disorder = BaseUtil.randomIntArray(100, 10);
        System.out.println(Arrays.toString(disorder));
        MergeSortTest mergeSortTest = new MergeSortTest();
        mergeSortTest.mergeSort(disorder);
        System.out.println(Arrays.toString(disorder));
    }
    private void mergeSort(int[] nums) {
        if (nums.length <= 1) return;
        mergeInternally(nums,0, nums.length -1 );
    }

    private void mergeInternally(int[] nums, int start, int end) {
        // 确定终止条件 递归到相等就返回不能递归了
        if (start >= end) return;

        // 确定中位数 防止middle超过Integer.MAX_VALUE
        int middle = start + (end - start) / 2;

        // 对前面进行排序
        mergeInternally(nums,start, middle);
        // 对后面进行排序
        mergeInternally(nums, middle + 1, end);

        // 合并结果
        merge(nums, start, middle, end);
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int s = start;
        int m = middle + 1;
        // 临时数组下标
        int l = 0;
        int[] tmp = new int[end - start + 1];
        // 比较合并的两个有序数组
        while (s <= middle && m <= end){
            if (nums[s] <= nums[m]){
                tmp[l++] = nums[s++];
            }else {
                tmp[l++] = nums[m++];
            }
        }
        // 比较完成之后可能会有数据没比较完 合并数据就行
        int temStart = s;
        int tempEnd = end;
        if (s <= middle){
            tempEnd = middle;
        }else {
            temStart = m;
        }
        while (temStart <= tempEnd){
            tmp[l++] = nums[temStart++];
        }
        // 把排序好的数组归并到原数组上
        if (end - start + 1 > 0){
            System.arraycopy(tmp, 0, nums,start, end - start + 1);
        }
    }
}
