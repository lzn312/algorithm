package search.logn;

import sort.nlogn.QuickSort;
import util.BaseUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找
 * 算法非常高效
 * 局限性:
 * 1.需要顺序表结构的数组才能使用 如果使用链表的话那么我们所说的时间复杂度就会变得很高(因为链表的随机下标访问时间复杂度是O(sort.n)
 * 2.需要有序的数组才行
 * 3.对于动态数组(即插入删除比较频繁的数组）=>动态数组(二分查找)
 * 4.数据量过大和数据量过小都不利于使用二分查找:
 * 数据量过大:
 * 因为数组支持随机下标访问的.数组在申请内存的时候是连续的~所以当数据量过大时可能无法申请较大的连续内存空间
 **/
public class BinarySearch {


    public static void main(String[] args) {
       /* int[] ints = {10, 27, 28, 29, 29, 30,38};
        System.out.println(Arrays.toString(ints));
        int i = simpleBinarySearch(29, ints);
        System.out.println(i);
        int i1 = binaryLastValue(29, ints);
        System.out.println(i1);
        int i2 = binaryEqAndLessValue(29,ints);
        System.out.println(i2);*/
       BinarySearch binarySearch = new BinarySearch();
       binarySearch.solve();
    }


    /**
     * 二分查找数组中某个值是否在内
     *
     * @param array 查找数组
     * @param i     查找元素
     * @return 返回数组下标
     **/
    public static int simpleBinarySearch(int i, int[] array) {

        if (array.length == 1) {
            if (array[0] == i) {
                return 0;
            }
        }

        int low = 0;
        int high = array.length - 1;

        //判断条件必须加上等于过一遍 反之发生死循环
        while (low <= high) {
            //确保数据太大不会溢出
            int mid = (low + (high - low) / 2);
            if (array[mid] == i) {
                return mid;
            }//如果中间值大于i说明在[low,mid)区间里面
            else if (array[mid] > i) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    /**
     * 二分查找数组某个值是否存在
     * 递归版
     *
     * @param array 数组
     * @param low   最小值
     * @param high  最大值
     * @param value 是否存在的值
     * @return 返回结果
     **/
    public static int recursiveBinarySearch(int low, int high, int value, int[] array) {
        //确定终止条件

        if (low > high) {
            return -1;
        } else {
            //算出中间值
            int mid = low + ((high - low) >> 1);

            if (array[mid] == value) {
                return mid;
            } else if (value < array[mid]) {
                high = mid - 1;
                return recursiveBinarySearch(low, high, value, array);
            } else {
                low = mid + 1;
                return recursiveBinarySearch(low, high, value, array);
            }
        }
    }


    /**
     * 查找第一个值等于给定元素的值
     *
     * @param value 查找值
     * @param array 查找数组
     **/
    public static int binaryFirstValue(int value, int[] array) {

        int low = 0;
        int high = array.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                high = mid - 1;
                result = mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }


    /**
     * 查找最后一个值等于给定元素的值
     *
     * @param value 查找值
     * @param array 查找数组
     **/
    public static int binaryLastValue(int value, int[] array) {

        int low = 0;
        int high = array.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == value) {
                low = mid + 1;
                result = mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }


    /**
     * 查找第一个值大于等于给定元素的值
     *
     * @param value 查找值
     * @param array 查找数组
     **/
    public static int binaryEqAndMoreValue(int value, int[] array) {

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        if (array[high] == value) {
            return high + 1;
        } else {
            return -1;
        }
    }

    /**
     * 查找第一个值大于等于给定元素的值
     *
     * @param value 查找值
     * @param array 查找数组
     **/
    public static int binaryEqAndLessValue(int value, int[] array) {

        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        if (array[low] == value) {
            return low - 1;
        } else {
            return -1;
        }
    }


    /**
     * 查找第一个值等于给定元素的值(递归版)还有问题
     *
     * @param value 查找值
     * @param array 查找数组
     **/
    public static int binaryFirstValueInternally(int[] array, int value, int low, int high) {
        int result = -1;
        if (low > high) return result;

        int mid = low + ((high - low) >> 1);
        if (array[mid] == value) {
            high = mid - 1;
            result = binaryFirstValueInternally(array, value, low, high);
            return result;
        } else if (array[mid] > value) {
            high = mid - 1;
            return binaryFirstValueInternally(array, value, low, high);
        } else {
            low = mid + 1;
            return binaryFirstValueInternally(array, value, low, high);
        }


    }


    /**
     * extend 扩展
     * 假设我们有 1000 万个整数数据，每个数据占 8 个字节，
     * 如何设计数据结构和算法，快速判断某个 整数是否出现在这 1000 万数据中？内存限制在100MB左右
     * 使用散列表和二叉树需要额外申请空间 所以在这里并不适用
     **/
    public static void solve() {
        //进行查找
        Random random = new Random();
        int[] ints = BaseUtil.randomIntArray(10000000, 10000000);
        long l = System.currentTimeMillis();
        //先对数据进行排序
        QuickSort.quickSort(ints, ints.length - 1);
        long l1 = System.currentTimeMillis();
        System.out.println(String.format("排序耗费:%s毫秒", l1 - l));
        //进行查找
//        int i = simpleBinarySearch(ints[random.nextInt(3000)], ints);
        int i = recursiveBinarySearch(0, ints.length - 1, ints[random.nextInt(3000)], ints);
        System.out.println(String.format("查找耗费:%s毫秒", System.currentTimeMillis() - l1));
        System.out.println(i);


    }

}
