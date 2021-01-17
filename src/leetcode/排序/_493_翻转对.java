package leetcode.排序;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 **/
public class _493_翻转对 {

    int ret;

    /**
     * 输入数组中的元素都在32位，但是 * 2就可能溢出了。这个我们要注意一下需要转换为long。
     * 这一题我们可以归并排序来做，因为归并时，先统计最小范围的逆序对，在统计更大范围的数，因为我们先统计小的，在统计大的，不会出现多统计和漏统计的情况。
     * 所以这一题的严格意义时间复杂度是nlogn，空间复杂度也是nlogn。
     **/
    public  int reversePairs(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        ret = 0;
        return innerMergeSort(nums, 0, nums.length - 1);

    }

    private int innerMergeSort(int[] nums, int left, int right) {

        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int cntL = innerMergeSort(nums, left, mid);
        int cntR = innerMergeSort(nums, mid + 1, right);

        int cnt = cntL + cntR;

        for (int l = left, tmp = mid + 1; l <= mid; l++) {
            while (tmp <= right && nums[l] / 2.0 > nums[tmp]) {
                tmp++;
            }
            // 起始是mid+1，tmp - tmpStart 则代表了满足上述条件的有几个cnt；
            cnt += tmp - (mid + 1);

        }

        merge(nums, left, mid, right);


        return cnt;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // merge sort
        // merge Op 比较前置数据和后置数据差异
        // 是否有必要排序? => 有必要排序，因为排序，在合并和，就不会在上述条件中出现满足的情况，因为num[i] < nums[j] 所以 nums[i]必定小于2 * nums[j];
        int[] cache = new int[right - left + 1];
        for (int l = left, r = mid + 1, cacheIndex = 0; l <= mid || r <= right; ) {
            // 如果l在mid范围内，且满足nums[l] < nums[r]
            if (l <= mid && ((r > right) || nums[l] < nums[r])) {
                cache[cacheIndex++] = nums[l++];
            } else {
                cache[cacheIndex++] = nums[r++];
            }
        }


        // 搞定原数组
        for (int i = 0, l = left; i < cache.length; i++) {
            nums[l++] = cache[i];
        }
    }


    public static void main(String[] args) {
        _493_翻转对 test = new _493_翻转对();

        System.out.println(test.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

}
