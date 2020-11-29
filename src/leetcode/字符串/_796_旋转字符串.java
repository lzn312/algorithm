package leetcode.字符串;

/**
 * 给定两个字符串, A 和 B。
 * <p>
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * <p>
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 * <p>
 * A 和 B 长度不超过 100。
 **/
public class _796_旋转字符串 {

    /**
     * 其实这题旋转字符串的本质还是比较字符串是否包含，
     * 我们可以通过观察可以知道，无论A怎么旋转: A + A 一定满足所有旋转的规则。
     * 我们只要判断A + A 是否包含模式串 B就行了。
     * 这样就转换成是否包含字符串的问题了
     **/
    public boolean rotateString1(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    /**
     * 这题要是衍生下来，估计就会考KMP了。我们看看KMP怎么写的
     * 其实KMP也是一个动态规划的
     **/
    public static boolean rotateString(String A, String B) {
        KMP kmp = new KMP(B);
        return kmp.search(A+A) > 0;
    }


    private static class KMP {
        private final String pat;
        private final int[][] next;


        public KMP(String pat) {
            this.pat = pat;

            // 构建next表
            int M = pat.length();
            next = new int[M][256];


            // 定义影子状态
            int X = 0;

            next[0][pat.charAt(0)] = 1;
            for (int j = 1; j < M; j++) {
                // 如果字符匹配的话，可以跳转到下一个字符的状态
                for (int i = 0; i < 256; i++) {
                    if (pat.charAt(j) == i) {
                        next[j][i] = j + 1;
                    } else {
                        // 如果不匹配当前状态转移至影子状态
                        next[j][i] = next[X][i];
                    }
                }
                // 当前的影子状态,其实也是上一个状态的影子状态
                X = next[X][pat.charAt(j)];
            }

        }


        /**
         * 查询就简单多了，我们按text进行扫描，如果匹配继续往下走，
         * 如果不匹配回退到影子状态
         **/
        public  int search(String text) {
            int N = text.length();
            int M = pat.length();

            // 确定当前状态
            int j = 0;
            for (int i = 0; i < N; i++) {

                j = next[j][text.charAt(i)];

                if (j == M) {
                    return i - M + 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        rotateString("abcde", "cdeab");
    }

}
