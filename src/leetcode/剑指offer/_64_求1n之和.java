package leetcode.剑指offer;

//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
//
//
// 示例 1：
//
// 输入: n = 3
//输出: 6
//
//
// 示例 2：
//
// 输入: n = 9
//输出: 45
//
//
//
//
// 限制：
//
//
// 1 <= n <= 10000
public class _64_求1n之和 {


    public int sumNums(int n) {
        // 因为什么都不能使用，我们第一个想的就是使用递归，但是递归没有if条件能使用，所以我们得使用其他取巧的方式
        // 我们可以想想 使用&&来进行下一步操作判断

        boolean b = (n > 0) && (n += sumNums(n-1)) > 0;
        return n;
    }
}



