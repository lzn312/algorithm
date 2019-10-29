package sort.nlogn;

import util.BaseUtil;

import java.util.Arrays;

/**
 * 归并排序
 * sort.nlogn
 * 核心思想:
 * 1.拆分后进行数据合并
 * 2.把排好序的数据进行比较
 * 递归核心思想:
 * 1.确定终止条件 q>=r
 * 2.确定递归表达式 merge(sort.n) = merge(q,sort.n/2)+merge(sort.n/2+1,sort.n)
 **/
public class MergeSort {


    public static void main(String[] args) {
        int[] disorder = BaseUtil.randomIntArray(100, 20);
        System.out.println(Arrays.toString(disorder));
        mergeSort(disorder, disorder.length - 1);
        System.out.println(Arrays.toString(disorder));
    }

    private static void mergeSort(int[] array, int n) {
        if (n <= 1) return;
        mergeInternally(array, 0, n);
    }

    /**
     * 归并内部排序
     *
     * @param q     起始点
     * @param r     终点
     * @param array 原始数组
     **/
    private static void mergeInternally(int[] array, int q, int r) {
        //确定终止条件
        if (q >= r) return;
        //确定中点,这样取值防止中点大于Integer.MAXVALUE
        int p = q + (r - q) / 2;

        mergeInternally(array, q, p);
        mergeInternally(array, p + 1, r);

        //进行数据合并
        merge(array, q, p, r);
    }

    /**
     * 数据合并
     *
     * @param q     起始点
     * @param p     终点
     * @param r     终点
     * @param array 数组
     **/
    private static void merge(int[] array, int q, int p, int r) {
        //准备排序条件
        int j = q;
        int k = p + 1;
        int l = 0;

        //创建临时排序数组
        int[] tmp = new int[r - q + 1];

        //对前后数组进行比较排序
        while (j <= p && k <= r) {
            if (array[j] <= array[k]) {
                tmp[l++] = array[j++];
            } else {
                tmp[l++] = array[k++];
            }
        }

        //因为数组归并最小值组合为[1] [2] 或者[2] [1] 所以比较数组一定是有序的 故可以直接往里面添加没有比较完的数据
        int start = j;
        int end = p;
        if (k <= r) {
            start = k;
            end = r;
        }
        while (start <= end) {
            tmp[l++] = array[start++];
        }


        //排序完成之后就要进行对原始数据进行合并~\(≧▽≦)/~
        //这里有一个比较巧妙的做法就是偏移量:循环tmp大小 看与q的偏移量是多少进行赋值
        if (r - q + 1 >= 0) System.arraycopy(tmp, 0, array, q, r - q + 1);
    }




    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     *
     * 说明:
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     *
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     * 这题就是归并排序的思想 比较两个数组 已经有序了,只要逐个比较就行
     **/
    public void mergeSortArray(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

