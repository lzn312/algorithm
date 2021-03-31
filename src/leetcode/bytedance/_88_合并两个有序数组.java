package leetcode.bytedance;


/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 **/
public class _88_合并两个有序数组 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int n1Index = m - 1;
        int n2Index = n - 1;

        int cursor = nums1.length - 1;

        while (n2Index >= 0) {
            // 倒序插入

            while (n1Index >= 0 && nums1[n1Index] > nums2[n2Index]) {
                exchange(nums1, cursor, nums1, n1Index);
                cursor--;
                n1Index--;
            }

            exchange(nums1, cursor, nums2, n2Index);
            cursor--;
            n2Index--;
        }


    }

    private void exchange(int[] target, int cursor, int[] source, int sIndex) {
        int tmp = target[cursor];
        target[cursor] = source[sIndex];
        source[sIndex] = tmp;

    }
}
