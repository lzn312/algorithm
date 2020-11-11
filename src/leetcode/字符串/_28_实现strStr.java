package leetcode.字符串;

/**
 *实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 **/
public class _28_实现strStr {


    /**
     * 这题使用Sunday算法来解，这算法看起来太高大上了，我也不懂，不过用来做
     * 包含字符串其实位置挺好做的。
     * 该算法的核心是:
     * 能跳过尽可能多的字符以进行下一步的匹配，从而提高了匹配效率。
     *
     * 字符串匹配算法第一步，都是把目标串和模式串对齐。不管是KMP，BM，SUNDAY都是这样。
     * SUNDAY算法，从头部开始比较，一旦发现不匹配，直接找到主串中位于模式串后面的第一个字符
     * 查看模式串中是否包含这个元素，如果不包含那就可以跳过一大片，从该字符的下一个字符开始比较。
     * SUNDAY算法的本质是:
     * 对齐目标串和模式串，从前向后匹配
     * 关注主串中位于模式串后面的第一个元素（核心）
     * 如果关注的字符没有在子串中出现则直接跳过
     * 否则开始移动模式串，移动位数 = 子串长度 - 该字符最右出现的位置(以0开始)
     * #
     **/
    public static  int strStr(String origin, String aim) {

        // 边界值判定
        if (aim == null || aim.equals("")) {
            return 0;
        }


        // 定义起始移动坐标
        int originIndex = 0;
        int aimIndex = 0;
        // 判定条件为匹配超过aim最大长度

        while (aimIndex < aim.length()) {
            // 如果目标索引已经超出了其长度，则说明不存在
            if (originIndex > origin.length() - 1) {
                return -1;
            }

            // 如果两个字符匹配，则进行移动匹配，如果全都匹配，那么originIndex就是对应的值
            if (aim.charAt(aimIndex) == origin.charAt(originIndex)) {
                aimIndex++;
                originIndex++;
            } else {
                // 如果对应的不匹配的话，我们得找主串的下一个字符
                int nextIndex = originIndex - aimIndex + aim.length();
                //判断下一个目标字符（上面图里的那个绿框框）是否存在。
                if (nextIndex < origin.length()) {
                    // 判断目标字符在模式串中匹配到，返回最后一个匹配的index
                    int step = aim.lastIndexOf(origin.charAt(nextIndex));
                    if (step == -1) {
                        // 不存在的话，设置到目标字符的下一个元素
                        originIndex = nextIndex + 1;
                    } else {
                        // 存在的话，移动对应的数字（参考上文中的存在公式）
                        originIndex = nextIndex - step;
                    }
                    //模式串总是从第一个开始匹配
                    aimIndex = 0;
                } else {
                    return -1;
                }
            }
        }
        return originIndex - aimIndex;

    }

    public static void main(String[] args) {
        strStr("Here is a little Hao", "little");
    }

}
