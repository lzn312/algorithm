package leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * 示例 2：
 * <p>
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * 示例 3：
 * <p>
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * 示例 4：
 * <p>
 * 输入：s = "aba"
 * 输出：[]
 *  
 **/
public class _830_较大分组的位置 {


    public List<List<Integer>> largeGroupPositionsSlow(String s) {
        List<List<Integer>> res = new ArrayList<>();

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {

            if (res.size() != pos + 1) {
                res.add(new ArrayList<>());
            }

            List<Integer> curRes = res.get(pos);
            if (curRes.size() == 0) {
                curRes.add(i);

            }

            // 终止
            if (i == s.length() - 1 || (i != s.length() - 1) && s.charAt(i) != s.charAt(i + 1)) {
                curRes.add(i);
                pos++;
            }
        }


        res.removeIf(next -> next.get(1) - next.get(0) < 2);


        return res;
    }


    // 可以用双指针来做，但是我没想到
    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> res = new ArrayList<>();


        int left = 0;
        while (left < s.length()){
            int count = 0;
            while (left + count < s.length() && s.charAt(left) == s.charAt(left + count)){
                count++;
            }
            if (count >= 3 ){
                List<Integer> curRes = new ArrayList<>(2);
                curRes.add(left);
                curRes.add(left + count -1 );
                res.add(curRes);
            }
            left += count;
        }


        return res;
    }


    public static void main(String[] args) {
        _830_较大分组的位置 test = new _830_较大分组的位置();
        System.out.println(test.largeGroupPositionsSlow("abbxxxxzyy"));
        System.out.println(test.largeGroupPositionsSlow("abcdddeeeeaabbbcd"));
        System.out.println(test.largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(test.largeGroupPositionsSlow("abc"));
    }


}
