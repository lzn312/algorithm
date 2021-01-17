package leetcode.数组;

import java.util.Arrays;

/**
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 **/
public class _1122_数组的相对排序 {

    // 对于前面的元素做统计排序，剩下的元素做升序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 题目就给了1000，所以我们直接构建一个1001的数组就行了
        int[] countArray = new int[1001];
        for (int val : arr1) {
            countArray[val]++;
        }

        int index = 0;
        for (int val : arr2) {
            while (countArray[val]-- > 0){
                arr1[index++] = val;
            }
        }
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i]-- > 0){
                arr1[index++] = i;
            }
        }

        return arr1;
    }


    public static void main(String[] args) {
        _1122_数组的相对排序 test = new _1122_数组的相对排序();
        System.out.println(Arrays.toString(test.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
