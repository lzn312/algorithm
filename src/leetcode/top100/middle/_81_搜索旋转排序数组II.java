package leetcode.top100.middle;


/**
 *
 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 示例 1:

 输入: nums = [2,5,6,0,0,1,2], target = 0
 输出: true
 示例 2:

 输入: nums = [2,5,6,0,0,1,2], target = 3
 输出: false
 **/
public class _81_搜索旋转排序数组II {


    /**
     * 这题是搜索旋转数组的一个衍生题目，维度多了的就是可能包含重复数字，其解题思路其实
     * 还是和二分查找没有区别
     **/
    public boolean search(int[] nums, int target) {


        if (nums.length == 0) {
            return false;
        }


        int left = 0;
        int right = nums.length -1 ;
        while (left <= right) {

            int mid = left + ((right - left + 1 ) >> 1);
            if (nums[mid] == target){
                return true;
            }
            // 左区间有序
            if (nums[left] < nums[mid]){
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            //
            else if (nums[left] > nums[mid]){
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _81_搜索旋转排序数组II ii = new _81_搜索旋转排序数组II();
        System.out.println(ii.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(ii.search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(ii.search(new int[]{1,3,5}, 1));
    }
}
