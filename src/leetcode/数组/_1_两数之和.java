package leetcode.数组;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * https://leetcode-cn.com/problems/two-sum/
 **/

public class _1_两数之和 {

    /**
     * 这题刷过,可以使时间复杂度控制在O(n) 空间复杂度控制在O(1)
     * 这题就是单纯的实现逻辑，不涉及使用什么算法
     * 使用hashMap完成,key为target - nums[i] ,val 为: i 如果存在key，则输出当前i和val就行。
     **/
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> resultMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])) {
                return new int[]{i, resultMap.get(target - nums[i])};
            }
            resultMap.put(nums[i], i);
        }

        return null;
    }

    /**
     * 有一个数组只包含整数，有正数或负数或0，
     * 且存在重复的数，请找出该数组中所有两两相加和为5的数和下标
     * 输入[2,4,6,0,6,-1.3]
     * 输出：
     * [2,3],[0,6]
     * [6,-1],[2,5]
     * [6,-1],[4,5]
     **/
    public static List<Integer[][]> twoSum1(int[] nums, int target) {
        Map<Integer, List<Integer>> resultMap = new HashMap<>(nums.length);
        List<Integer[][]> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> integers = resultMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
            integers.add(i);

        }
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])) {
                int val = nums[i];
                int finalI = i;
                resultMap.get(target - nums[i]).stream().filter(s -> finalI < s).forEach(
                        s -> {
                            Integer[][] resultArray = {{val, target - val}, {finalI, s}};
                            result.add(resultArray);
                        }
                );
            }
        }

        return result;
    }

    /**
     * 有一个数组只包含整数，有正数或负数或0，
     * 且存在重复的数，请找出该数组中所有两两相加和为5的数和下标
     * 输入[2,4,6,0,6,-1.3]
     * 输出：
     * [2,3],[0,6]
     * [6,-1],[2,5]
     * [6,-1],[4,5]
     **/
    public static List<Integer[][]> twoSum2(int[] nums, int target) {
        List<Integer[][]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                break;
            }
            int num = nums[i];
            int l = i + 1;
            int tarVal = target - num;
            while (l < nums.length) {
                if (tarVal== nums[l]) {
                    Integer[][] resultArray = {{num, tarVal}, { i, l}};
                    result.add(resultArray);
                }
                l++;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 0, 6, -1, 3};
        List<Integer[][]> integers = twoSum1(nums, 5);
        integers.forEach(
                s -> System.out.println(Arrays.toString(s[0]) + "," + Arrays.toString(s[1]))
        );


        integers = twoSum2(nums, 5);
        integers.forEach(
                s -> System.out.println(Arrays.toString(s[0]) + "," + Arrays.toString(s[1]))
        );

    }


}
