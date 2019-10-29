package sort.n;

import java.util.Arrays;

/**
 * @author Leezer
 * @date 2019-04-11
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 **/
public class MajorElements {

    /**
     * 该提第一个想到的是对数据进行排序
     * 然后如果保证必定存在众数的话那么
     * 中间数一定是该众数
     * 时间复杂度为O(n)
     * 空间复杂度为O(1)
     * 但是使用计数排序不能统计负数所以该方法有缺陷
     **/
    public static int majorityElement1(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else{
            int max = 0;
            for (int i: nums){
                if(i > max){
                    max = i;
                }
            }
            int[] count = new int[max + 1];
            for(int i = 0; i<count.length;i++){
                count[i] = 0;
            }
            for(int i : nums){
                count[i]++;
            }
            for(int i = 0; i<count.length;i++){
                if(count[i] > nums.length / 2) return i;
            }
            return -1;
        }
    }


    /**
     * @link https://www.zhihu.com/question/49973163
     * 使用摩尔投票算法进行,摩尔投票算法使用的是两两相互抵消
     * 当保证了一定存在众数时,最后count肯定存在即存在那个数就为众数
     * 好比我一个军队10人 地方有3个国家每个国家2个人 派出去打仗 一换一 最后我方剩下了那么我方就胜利了。。。
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     **/
    public static int majorityElement2(int[] nums) {
        if (nums.length == 0){
            return -1;
        }else if (nums.length == 1){
            return nums[0];
        }else {
            int count = 0;
            int major = nums[0];
            for (int i : nums){
                if (i != major){
                    count--;
                    if (count == 0){
                        count = 1;
                        major = i;
                    }
                }else {
                    count++;
                }
            }
            return major;
        }
    }


    /**
     * 直接进行排序后获取
     **/
    public static int majorityElement3(int[] nums) {
        if (nums.length == 0){
            return -1;
        }else if (nums.length == 1){
            return nums[0];
        }else {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }




    public static void main(String[] args) {
        int[] nums = {1,2,5,3,5,4,4,5};
        System.out.println(majorityElement1(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
    }
}
