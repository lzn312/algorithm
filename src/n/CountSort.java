package n;

import util.BaseUtil;

import java.util.Arrays;

/**
 * 计数排序
 * O(n+k) k 代表数据范围 n代表均分的桶
 * 适用范围
 * 数据量不大即:k不能远大于n
 * 数据分布较为均匀 如果要统计非负整数之外的类型数据就要转换为整型数据 增大了n的个数
 **/
public class CountSort {

    public static void main(String[] args) {
        int[] ints = BaseUtil.randomIntArray(100, 10);
        countSort(ints, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 计数排序
     * 核心思想:
     * 对相同的值进行count统计
     * 通过巧妙的临时数组重新进行排序
     **/
    public static void countSort(int[] array, int size) {
        if (size <= 1) return;

        //找出数据中最大值
        int max = 0;
        for (int i = 1; i <= size; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        //初始化一个count数组 size为max
        int[] countArray = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            countArray[i] = 0;
        }

        //进行个数统计
        for (int a : array) {
            countArray[a]++;
        }

        //把统计好的数据进行前后累加
        //目的是为了下一步创建临时数组的时候能确定countArray[i]的范围 即从countArray[i-1] ~countArray[i]
        for (int i = 1; i <= max; i++) {
            countArray[i] = countArray[i - 1] + countArray[i];
        }


        //创建临时数组,准备排序
        int[] tmp = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            if (countArray[array[i]] > 0) {
                // 确定取出下标 没取出一次数据count值-1 下标减1
                int index = countArray[array[i]] - 1;
                tmp[index] = array[i];
                countArray[array[i]]--;
            }
        }

        System.arraycopy(tmp, 0, array, 0, size + 1);

    }
}
