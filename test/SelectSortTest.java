import java.util.Arrays;

public class SelectSortTest {
    public   int[] selectSort(int[] nums){
        if (nums.length <= 1) return nums;
        for(int i = 0; i<nums.length ; i++){
            // 从后面选取最小的数,和前面进行交换
            int min = nums[i];
            int index = i;
            for (int j = i+1; j<nums.length;j++){
                // 找出后面最小的数进行交换
                if (nums[j] < min){
                    min = nums[j];
                    index = j;
                }
            }

            if (index != i){
               int temp = nums[index];
               nums[index] = nums[i];
               nums[i] = temp;
            }

        }
        return nums;
    }

    public static void main(String[] args) {
        SelectSortTest selectSortTest = new SelectSortTest();
        int[] nums = new int[]{54,78,23,87,345,8,456,5,234,6234,6,7,234,467,46};
        System.out.println(Arrays.toString(selectSortTest.selectSort(nums)));
    }
}
