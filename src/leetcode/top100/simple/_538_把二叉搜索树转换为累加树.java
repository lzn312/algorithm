package leetcode.top100.simple;

import leetcode.树.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 **/
public class _538_把二叉搜索树转换为累加树 {
    public static TreeNode convertBST(TreeNode root) {
        /**
         * 第一个想法就是与各种遍历有关
         * 想用栈来实现 先把右节点全部压入栈中 然后定义一个sum向量记录当前累加值
         * 在取左节点把左节点的右节点都压入栈中
         * 应该归一的去看待问题
         * 题目没有说区分左右节点那么应该统一考虑问题
         **/
        if (root == null) return null;
        // 定义一个累加值代表当前累加结果
        int sum = 0;
        // 定义一个指向root的node引用
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()
                || // node不为空是因为我们也会操作node
                node != null){
            // 先把右节点全部压入到栈里面
            while (node != null){
                stack.push(node);
                node = node.right;
            }
            // 第一次到这里栈里肯定是最右的node
            node = stack.pop();
            sum += node.val;
            // 赋予累加值
            node.val = sum;
            // 记录完成就把引用指向左节点
            node = node.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        TreeNode  left = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(13);
        TreeNode treeNode5 = new TreeNode(20);
        treeNode1.left = treeNode4;
        treeNode1.right = treeNode5;
        left.left = treeNode2;
        left.right = treeNode3;
        treeNode.left = left;
        treeNode.right = treeNode1;
        convertBST(treeNode);
    }
}
