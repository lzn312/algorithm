package leetcode.剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leezer
 * @date 2020/11/17 9:43 上午
 **/
public class _57_和为s的连续正数序列 {


    public  int[][] findContinuousSequence(int target) {
        // 有优化的空间点，因为这个target = target / 2 。所以不用遍历其后面是节点值

        List<int[]> res = new ArrayList<>();
        int left = 1;
        int right = 1;
        int winMax = 0;


        while (left <= target / 2) {
            // 如果其比target小则right进行移动
            if (winMax < target) {
                winMax += right;
                right++;
            }
            // 如果其比target大，则左窗口往前移
            else if (winMax > target) {
                winMax -= left;
                left++;
            }else {
                // 相等时直接构建数据结果集
                int[] resTemp = new int[right - left];
                for (int k = left; k < right; k++) {
                    resTemp[ k - left ] = k;
                }
                res.add(resTemp);
                winMax -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }



}

