package review.一月.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums.length <= 2){
            return res;
        }

        // 这里我们有一个小技巧，就是可以先给数组排序，排序之后，如果我们起始位置就是大于0的元素，则可以直接过滤数据了。
        Arrays.sort(nums);
        // 我们应该给它降维，成二维，然后再去做这一题就会简单很多
        for (int i = 0; i < nums.length; i++) {
            // 如果这个定位数已经大于0就没有必要在往后遍历了
            int sentinelNode = nums[i];
            if (sentinelNode > 0) {
                break;
            }

            // 如果 i和i-1相等则跳过，因为i-1已经处理了这个数据
            if (i > 0 && sentinelNode == nums[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length -1 ;

            while (start < end) {

                // 如果相等则加入进去
                if (sentinelNode  -nums[start] - nums[end] == 0) {
                    List<Integer> currArray = new ArrayList<>(3);
                    currArray.add(sentinelNode);
                    currArray.add(nums[start]);
                    currArray.add(nums[end]);
                    res.add(currArray);
                }

                // 处理start和end
                while (start < end && nums[start] == nums[start + 1 ]){
                    start++;
                }

                while ( start < end  && nums[end] == nums[end - 1]) {
                    end--;
                }
                // 如果没有相等的，就做一次++，--
                start++;
                end--;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        _15_三数之和 test = new _15_三数之和();
        System.out.println(test.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
