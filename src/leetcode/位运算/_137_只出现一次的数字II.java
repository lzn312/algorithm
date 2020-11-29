package leetcode.位运算;

/**
 * @author Leezer
 * @date 2020/11/23 9:51 上午
 **/
public class _137_只出现一次的数字II {

    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int next : nums) {
            b = (b ^ next) & ~a;
            a = (a ^ next) & ~b;         }
        return b;
    }


    public static void main(String[] args) {
        _137_只出现一次的数字II  test = new _137_只出现一次的数字II();

        System.out.println(test.singleNumber(new int[]{1,1,1,2}));
    }
}
