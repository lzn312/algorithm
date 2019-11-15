package leetcode.top100.simple;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 链接：https://leetcode-cn.com/problems/majority-element
 **/
public class _169_求众数 {
    /**
     * 第一反应是使用计数器来做。维护一个数组然后在每个位置放入具体出现该数的次数。
     * 但是这样时间复杂度为O(m+n)
     * 空间复杂度为O(n) 不太理想,考虑放弃
     * 以前做过类似求众数的题，使用的是摩尔投票算法。
     * 用排序算法来做其实会更好,但是我觉得摩尔投票算法更好玩
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     **/
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int count = 0;
        Integer candidate = null ;
        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }
            count +=  (candidate == num) ? 1: -1;
        }
        return candidate;
    }
}
