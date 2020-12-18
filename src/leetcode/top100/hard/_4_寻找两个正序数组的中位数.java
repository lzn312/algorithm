package leetcode.top100.hard;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 **/
public class _4_寻找两个正序数组的中位数 {


    /**
     * 这一题没有想到m+n的做法，log(m+n)要二分法来做，但是我没想到二分法如何实现，中位数，按道理我们只需要遍历(len) /2 次就行了。
     **/
    public  static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length ;
        int n1 = nums2.length;

        int tempVal = -1;
        int nextVal  = -1;
        int len = n + n1;
        int nums1Start = 0, nums2Start = 0;

        for (int i = 0; i <= (len >> 1); i++) {
            // temp保存上一个next值
            tempVal = nextVal;
            if (nums1Start < n && (nums2Start >= n1 || nums1[nums1Start] < nums2[nums2Start])){
                nextVal = nums1[nums1Start++];
            }else {
                nextVal = nums2[nums2Start++];
            }
        }

        if ((len & 1) == 0){
            return (tempVal + nextVal) / 2.0;
        }else {
            return nextVal;
        }

    }


    public static void main(String[] args) {

        int[] nums1 = new int[]{-1,1,3,5,7,9};

        int[] nums2 = new int[]{2,4,6,8,10,12,14,16};


//        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));

    }

}
