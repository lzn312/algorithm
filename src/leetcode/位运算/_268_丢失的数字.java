package leetcode.位运算;

import java.util.stream.IntStream;

/**
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 *
 *  
 *
 * 进阶：
 *
 * 你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：2
 * 解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 3：
 *
 * 输入：nums = [9,6,4,2,3,5,7,0,1]
 * 输出：8
 * 解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
 * 示例 4：
 *
 * 输入：nums = [0]
 * 输出：1
 * 解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。
 *  
 *
 *
 **/
public class _268_丢失的数字 {


    /**
     * 版本一，使用数学公式求解，因为其最终只丢失了一个元素,那么如果这个元素不丢失，其实他就是一个等差数列
     * 满足: sum(0...n) = n * (n +1) /2,我们只需要记录该数组的和，一相减就可以求出来了
     **/
    public int missingNumber1(int[] nums) {
        int sumN = (nums.length * (nums.length + 1)) /2;
        int sum = IntStream.of(nums).sum();
        return sumN - sum;
    }



    /**
     * 版本二: 我们使用异或运算来解这一题，还是利用两两相等异或为0的性质，假设我们有I个数，那么下标和数组之间一定满足相等的关系。
     * 我们只需要对齐异或，那么其中确实的元素就是本身;
     **/
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^i;
        }

        return res ^ nums.length;
    }


    public static void main(String[] args) {
        _268_丢失的数字 test = new _268_丢失的数字();
        System.out.println(test.missingNumber1(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(test.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(test.missingNumber1(new int[]{0}));
        System.out.println(test.missingNumber(new int[]{0}));
    }
}
