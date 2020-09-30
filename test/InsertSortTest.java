import java.util.Arrays;

/**
 * 插入排序
 **/
public class InsertSortTest {
    public int[] insertSort(int[] nums){
        if (nums.length <= 1) return nums;
        // 插入排序的核心思想就是针对小的区域进行插入为排序的值
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            // 选取已排序的区域进行位置判定
            int index = i -1;
            for (int j = i-1; j>=0; j--){
                // 如果值比它大那么要诺位置了
                if (nums[j] > value){
                    nums[j+1] = nums[j];
                    index = j;
                }else {
                    break;
                }
            }
            nums[index] = value;
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertSortTest insertSortTest = new InsertSortTest();
        int[] nums = new int[]{3,5,7,1,2,9,4};
        System.out.println(Arrays.toString(insertSortTest.insertSort(nums)));
    }
}
