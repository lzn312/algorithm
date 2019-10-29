package leetcode.树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 **/
public class _144_二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归太简单了 转换一下思想就是
        List<Integer> result = new ArrayList<>();
        // 先把传进来的节点加入栈里面
        // 递归太简单了 转换一下思想就是用栈来做
        Stack<TreeNode > stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        right.right = new TreeNode(3);
        root.right = right;

        _144_二叉树的前序遍历 so = new _144_二叉树的前序遍历();
        List<Integer> integers = so.preorderTraversal(root);
        System.out.println(integers);

    }
}
