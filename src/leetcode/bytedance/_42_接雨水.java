package leetcode.bytedance;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *  
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 **/
public class _42_接雨水 {

    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int res = 0;
        int left =0;
        int right = height.length -1;
        int lMax = 0;
        int rMax = 0;
        while (left <= right) {
            lMax = Math.max(height[left] , lMax);
            rMax = Math.max(height[right], rMax);

            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            }else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        _42_接雨水 test = new _42_接雨水();
        System.out.println(test.trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


}
