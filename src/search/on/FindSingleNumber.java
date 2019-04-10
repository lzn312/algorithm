package search.on;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * ps:开始并没有想到使用异或条件来判断
 * planA: 时间:（o(nlogn)) 空间:(O(1))
 * 1.对原数组进行排序
 * 2.循环比较数据前一位 或者后一位 如果不等就说明得到了结果
 * planB: 时间:（o(n)) 空间:(O(1))
 * 1.使用异或(异或^,因为 a^a = 0; a ^ 0 = a; a^b = 1; a ^ b ^ c = a ^ c ^ b)
 * 2.所以 a ^ b ^ c ^ b ^c = a ^ b ^ b ^ c ^ c = a ^ 0 = a;
 **/
public class FindSingleNumber {

    /**
     * @param nums 传入数组
     **/
    public static int singleNumber(int[] nums){
        if (nums.length == 0){
            return -1;
        }else if (nums.length == 1){
            return nums[0];
        }else {
            int num = 0;
            for (int s : nums){
                num ^= s;
            }
            return num;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[1];
        System.out.println(singleNumber(nums));
        nums = new int[]{1};
        System.out.println(singleNumber(nums));
        nums = new int[]{7,2,3,4,5,6,6,5,4,3,2};
        System.out.println(singleNumber(nums));
    }
}
