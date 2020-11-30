package leetcode.二分法;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 **/
public class _153_寻找旋转排序数组中的最小值 {


    /**
     * 这题我们可以使用二分法来解决，因为它是升序的，并且没有相等的节点，这样的话我们就可以
     * 使用二分法来查找对应的节点
     **/
    public int findMin(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 这种情况在左区间
            if (nums[mid] > nums[right]) {
                left = mid +1;
            }else {
                right = mid;
            }
        }
        
        return nums[left];

    }

    public static void main(String[] args) {
        _153_寻找旋转排序数组中的最小值 test = new _153_寻找旋转排序数组中的最小值();
        System.out.println(test.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(test.findMin(new int[]{3,4,5,6,1,2}));
    }
}
