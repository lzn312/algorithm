package leetcode.递归;

import java.util.ArrayList;
import java.util.List;

/**
 *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 *
 **/
public class _22_括号生成 {


    /**
     * 这题其实我们可以转换一下思路，给定了两个字符，'(',')',在2n个格子里的组合顺序，
     * 我们可以使用递归的思想来实现。递归是有模板的。
     **/
    public List<String> generateParenthesis(int n) {

        // 先不管输出结果，我们先验证自己的想法,
//        generatev1(0, 2 * n, "");
        // 我们上述的递归，没有问题，输出了所有括号的组合，但是呢，有一个问题在于，题目需要的是有效的括号，我们有一些括号是不合法的，我们需要改版一下
        // 我们想一下合法的定义，我们必须是左括号开头，并且追加的右括号数量必须小于等于左括号的数量，我们来改进一下
        List<String> res = new ArrayList<>();
        generatev2(0, 0, n, "", res);
        return res;
    }

    private void generatev2(int left, int right, int max, String s, List<String> res) {

        // terminate
        if (left == max && right == max){
            res.add(s);
            return;
        }

        // 我们来判断一下合法性的使用
        if ( left < max ){
            generatev2(left + 1, right, max, s + '(', res);
        }

        // 右括号必选放在左括号下面,且必须小于左括号的数量
        if ( right < left){
            generatev2(left, right + 1, max, s + ')', res);
        }
    }

    private void generatev1(int level, int max, String s) {
        // terminate
        if(level == max){
            // 输出结果
            System.out.println(s);
            return;
        }

        // process 要么都是左括号，要么组合加一个右括号
        generatev1( level + 1, max , s + '(');
        generatev1( level + 1, max , s + ')');


    }


    public static void main(String[] args) {
        _22_括号生成 v = new _22_括号生成();
        List<String> strings = v.generateParenthesis(3);
        System.out.println(strings);
    }
}
