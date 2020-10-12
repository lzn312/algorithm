package leetcode.数组;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Leezer
 * @date 2020/9/30 3:19 下午
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 **/
public class _350_两个数组的交集II {

    /**
     * 如果一次性加载的做法，可以是把数据转换为map，然后
     * 通过对比两个数组只之间是否存在相同的元素，如果存在的话就把和累加
     **/
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> integerMap = Arrays.stream(nums1)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));
        int k = 0;
        for (int num : nums2) {
            Integer nums = integerMap.getOrDefault(num, 0);
            if (nums > 0) {
                nums2[k] = num;
                integerMap.put(num, --nums);
                k++;
            }
        }
        return Arrays.stream(nums2).limit(k).toArray();
    }

    /**
     * 如果一次性加载的做法，可以是把数据转换为map，然后
     * 通过对比两个数组只之间是否存在相同的元素，如果存在的话就把和累加
     **/
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int j = 0;
        int k = 0;
        int l = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] > nums2[k]) {
                k++;
            } else if (nums1[j] < nums2[k]) {
                j++;
            } else {
                nums1[l] = nums1[j];
                j++;
                k++;
                l++;
            }
        }
        return Arrays.stream(nums1).limit(l).toArray();
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5, 6, 7, 8, 9, 0, 2};
        int[] nums2 = {1, 2, 3};

        System.out.println(Arrays.toString(intersect1(nums1, nums2)));
        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
    }


}
