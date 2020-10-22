package leetcode.top100.simple;

/**
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 *
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 *
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 *
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 *
 **/
public class _925_长按键入 {


    public static boolean isLongPressedName(String name, String typed) {
        int nameNode = 0;

        for (int i = 0; i < typed.length();) {
            // 如果 当前没到了名字结束两字符相等
            if (nameNode < name.length() && name.charAt(nameNode) == typed.charAt(i)) {
                i++;
                nameNode++;
            }
            // 如果当前不等就++
            else if (  i> 0 &&typed.charAt(i - 1) == typed.charAt(i)) {
                i++;
            } else {
                return false;
            }
        }

        return nameNode == name.length();
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("leelee", "lleelleee"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("dfuyalc", "fuuyallc"));

    }



}
