package leetcode.字符串.操作类;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 **/
public class _344_反转字符串 {

    public void reverseString(char[] s) {
        if ( s == null || s.length == 0){
            return;
        }
        int right = s.length -1 ;
        int mid = right >> 1;

        for (int i = 0; i <= mid; i++) {
            char tmp = s[right - i];
            s[right - i ] = s[i];
            s[i] = tmp;
        }
    }


    public static void main(String[] args) {
        _344_反转字符串 test = new _344_反转字符串();
        char[] char1 = "helSlo".toCharArray();
        char[] char2 = "Hannah".toCharArray();
        test.reverseString(char1);
        System.out.println(char1);
        test.reverseString(char2);
        System.out.println(char2);
    }
}
