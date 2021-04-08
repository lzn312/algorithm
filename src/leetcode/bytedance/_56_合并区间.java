package leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *  
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 **/
public class _56_合并区间 {

    /**
     * 排序，然后输出
     **/
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        // 排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int left =interval[0];
            int right = interval[1];

            if (res.isEmpty() || res.get(res.size() -1 )[1] < left) {
                res.add(new int[]{left,right});
            }
            else {
                res.get(res.size() - 1 )[1] = Math.max(res.get(res.size() - 1 )[1],right);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
