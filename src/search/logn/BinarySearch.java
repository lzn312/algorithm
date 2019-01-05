package search.logn;

import java.util.Arrays;

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
 *
 **/
public class BinarySearch {


    public static void main(String[] args) {
        int[] ints = {13, 16, 18, 26, 29, 29, 37, 38, 47, 56, 63, 64,  77, 80, 88, 90, 96, 99, 100,107, 107, 109, 112, 115, 119, 122, 129, 131, 134, 141, 148, 152, 159, 161, 167, 172, 178, 187, 191, 194, 200, 206, 214, 216, 225, 228, 232, 237, 246, 246, 251, 252, 254, 256, 257, 263, 272, 278, 283, 287, 291, 297, 303, 312, 314, 320, 324, 326, 328, 328, 331, 331, 332, 335, 344, 353, 360, 369, 373, 374, 383, 383, 392, 395, 401, 405, 411, 411, 413, 416, 423, 431, 435, 435, 443, 444, 445, 451, 459, 465, 467};
        System.out.println(Arrays.toString(ints));
        int i = simpleBinarySearch(100, ints);
        int i1 = recursiveBinarySearch(0,ints.length  -1 ,100, ints);
        System.out.println(i);
        System.out.println(i1);
    }



    /**
     * 二分查找数组中某个值是否在内
     * @param array 查找数组
     * @param i  查找元素
     * @return 返回数组下标
     **/
    public static int simpleBinarySearch(int i,int[] array){

        if (array.length == 1){
            if (array[0] == i){
                return 0;
            }
        }
        
        int low = 0;
        int high = array.length-1;

        //判断条件必须加上等于过一遍 反之发生死循环
        while (low<=high){
            //确保数据太大不会溢出
            int mid = (low + (high - low) /2);
            if (array[mid] == i){
                return mid;
            }//如果中间值大于i说明在[low,mid)区间里面
            else if (array[mid] > i){
                high = mid -1 ;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }



    /**
     * 二分查找数组某个值是否存在
     * 递归版
     * @param array 数组
     * @param low 最小值
     * @param high 最大值
     * @param value 是否存在的值
     * @return 返回结果
     **/
    public static int recursiveBinarySearch(int low,int high,int value,int[] array){
        //确定终止条件

        if (low > high){
            return  -1;
        } else {
            //算出中间值
            int mid = low + ((high - low) >> 1);

            if (array[mid] == value){
                return mid;
            }else if (value < array[mid]){
                high = mid - 1;
                return recursiveBinarySearch(low,high,value,array);
            }else {
                low = mid + 1;
                return recursiveBinarySearch(low,high,value,array);
            }
        }
    }
}
