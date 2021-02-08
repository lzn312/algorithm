package review.二月.tree;

import leetcode.树.TreeNode;

public class _226_翻转二叉树 {


    public TreeNode invertTree(TreeNode root) {

        // 我们先使用递归来做，递归其实就是完几个遍历，我们看一看题目要求
        innerInvertTree(root);
        return root;
    }

    private void innerInvertTree(TreeNode node) {

        //terminator
        if (node == null) {
            return;
        }

        // op
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;

        // recursive
        innerInvertTree(left);
        innerInvertTree(right);
    }

}
