package leetcode.top100.middle;

/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 * <p>
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 * <p>
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 *  
 **/
public class _33_搜索旋转排序数组 {


    /**
     * 这题其实就是一个二分查找的变种，因为会产生旋转
     **/
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            // 如果起始值，正常小于中间值，我们就按照正常的纬度走
            if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }

        }
        return -1;
    }


    public static void main(String[] args) {
        _33_搜索旋转排序数组 test = new _33_搜索旋转排序数组();

//        System.out.println(test.search(new int[]{4,5,6,0,1,2,3}, 6));
//        System.out.println(test.search(new int[]{4,5,6,7,8,1,2,3}, 8));
//        System.out.println(test.search(new int[]{1,3,5}, 3));
//        System.out.println(test.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(test.search(new int[]{3, 1},
                1));
    }
}
