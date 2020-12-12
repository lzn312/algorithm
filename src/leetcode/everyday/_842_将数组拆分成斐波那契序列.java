package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leezer
 * @date 2020/12/8 1:04 下午
 **/
public class _842_将数组拆分成斐波那契序列 {
    /*
    private void backtrack("原始参数") {
        //终止条件(递归必须要有终止条件)
        if ("终止条件") {
            //一些逻辑操作（可有可无，视情况而定）
            return;
        }

        for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
            //一些逻辑操作（可有可无，视情况而定）

            //做出选择

            //递归
            backtrack("新的参数");
            //一些逻辑操作（可有可无，视情况而定）

            //撤销选择
        }
    }*/



    public List<Integer> splitIntoFibonacci(String S) {

        List<Integer> res = new ArrayList<>();
        // 进入回溯模板
        backtrack(S.toCharArray(), res, 0);
        return res;
    }

    private boolean backtrack(char[] digit, List<Integer> res, int index) {
        // 写出终止条件
        if (index >= digit.length || res.size() >= 3) {
            return true;
        }

        // 开始循环
        for (int i = index; i < digit.length; i++) {
            if (digit[index] == '0' && i > index) {
                break;
            }
            int size = res.size();

            // 生成数字
            long num = subNum(digit,index, i+1);
            // 如果大于了，则直接溢出
            if (num > Integer.MAX_VALUE) {
                break;
            }
            // 如果查找的num值超过了前两个数之和，那后面也不用找了。
            if (res.size() >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            // 如果小于1个，或者当前满足菲薄纳妾则加入
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add((int) num);
                // 如果条件都满足了
                if (backtrack(digit, res, i + 1)) {
                    return true;
                }
            }

            // 撤销这一步
            res.remove(res.size() - 1);
        }
        return false;
    }

    /**
     *  public boolean backtrack(char[] digit, List<Integer> res, int index) {
     *         //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
     *         if (index == digit.length && res.size() >= 3) {
     *             return true;
     *         }
     *         for (int i = index; i < digit.length; i++) {
     *             //两位以上的数字不能以0开头
     *             if (digit[index] == '0' && i > index) {
     *                 break;
     *             }
     *             //截取字符串转化为数字
     *             long num = subDigit(digit, index, i + 1);
     *             //如果截取的数字大于int的最大值，则终止截取
     *             if (num > Integer.MAX_VALUE) {
     *                 break;
     *             }
     *             int size = res.size();
     *             //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
     *             if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
     *                 break;
     *             }
     *             if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
     *                 //把数字num添加到集合res中
     *                 res.add((int) num);
     *                 //如果找到了就直接返回
     *                 if (backtrack(digit, res, i + 1))
     *                     return true;
     *                 //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
     *                 res.remove(res.size() - 1);
     *             }
     *         }
     *         return false;
     *     }
     *
     **/

    private long subNum(char[] digit, int start, int end) {
        long res = 0;
        for (int i = start; i < end; i++) {
            res = res * 10 + digit[i];
        }
        return res;
    }
}
