package review.一月.array;

public class _283_移动零 {

    // 这题就用一个指针，来表示当前以完成移动的元素就行了
    public void moveZeroes(int[] nums) {
        if (nums.length == 0){
            return;
        }
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }


}
