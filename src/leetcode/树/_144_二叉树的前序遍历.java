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

    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        innerPreOrder(root);
        return  res;

    }

    private void innerPreOrder(TreeNode node) {
        if (node == null) return;
        res.add(node.val);
        innerPreOrder(node.left);
        innerPreOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        _144_二叉树的前序遍历 so = new _144_二叉树的前序遍历();
        List<Integer> integers = so.preorderTraversal1(root);
        System.out.println(integers);
    }
}
