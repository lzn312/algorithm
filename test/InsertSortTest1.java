public class InsertSortTest1 {


    public void sort(int[] nums){
        if (nums.length <= 1){
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int index =  i -1;
            for (int j = index;j>=0;j--){
                if (nums[j] > value){
                    nums[j+1] = nums[j];
                    index = j;
                }else {
                    break;
                }
            }
            nums[index] = value;
        }

    }
}
