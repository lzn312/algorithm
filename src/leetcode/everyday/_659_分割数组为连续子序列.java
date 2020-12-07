package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * <p>
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 *  
 * <p>
 * 示例 3：
 * <p>
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 **/
public class _659_分割数组为连续子序列 {


    /**
     * 这题使用贪心算法就能解决，我们就假设我们至多能统计N个子序列，我们的目的就是如果该数不是重复，并且往后追加的时候进行追加
     * z专业那个的
     * 使用两个hash表达。
     * 如果
     **/
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        // 定义一个存储map表示以i结尾时，是否满足上述子序列成立条件 1为成立，0为不成立
        Map<Integer, Integer> tailMap = new HashMap<>();
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }


        for (int num : nums) {
            Integer count = numCount.get(num);
            if (count <= 0) {
                continue;
            }
            // 如果当前count大于0，且连续数组map的上一个元素大于0，说明可以追加
            if (tailMap.getOrDefault(num - 1, 0) > 0) {
                numCount.put(num, count - 1);
                // 这里减了之后，下一次就为0了，减成负数的就不会在走这个判断了。
                tailMap.put(num - 1, tailMap.get(num - 1) - 1);
                tailMap.put(num, tailMap.getOrDefault(num,0) + 1);
            }
            // 不满足上述要求说明前面没有连续的子序列，我们要判断其是否能组成连续的子序列
            else if (numCount.getOrDefault(num + 1,0) > 0 && numCount.getOrDefault(num + 2, 0 ) > 0) {
                numCount.put(num, count - 1);
                numCount.put(num + 1, numCount.get(num + 1) - 1);
                numCount.put(num + 2, numCount.get(num + 2) - 1);
                // 当前组成一个以num + 2结尾的连续子序列了
                tailMap.put(num + 2, tailMap.getOrDefault(num + 2, 0) +1 );
            } else {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        _659_分割数组为连续子序列 test =new _659_分割数组为连续子序列();
        System.out.println(test.isPossible(new int[]{1, 2, 3, 3, 4, 4,5,5 }));
        System.out.println(test.isPossible(new int[]{1,2,3,4,4,5}));
    }
}
