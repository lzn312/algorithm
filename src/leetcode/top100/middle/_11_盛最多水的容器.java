package leetcode.top100.middle;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * <p>
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 **/
public class _11_盛最多水的容器 {


    /**
     * 我们可以使用双指针来进行缩减空间实现
     **/
    public  int maxArea(int[] nums) {
        if (nums.length == 0){
            return 0 ;
        }

        int res = 0;
        int prev = 0;
        int back = nums.length -1 ;
        while (prev < back){
            // 因为柱子只能指向较低长度所以我们需要选取出其当前的长度
            int tmpRes = (back - prev) * Math.min(nums[prev], nums[back]);
            // 选出面积最大区域存储
            res = Math.max(res, tmpRes);


            // 我们需要移动指针来缩减区域，如果我们不变动最小的柱子，那么面积永远不可能增大，我们只有变动其下标的位置才可能增大面积
            if (nums[prev] < nums[back]) {
                prev++;
            }else {
                back--;
            }
        }

        return res;

    }


}
