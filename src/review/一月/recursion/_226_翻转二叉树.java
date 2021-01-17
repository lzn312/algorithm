package review.一月.recursion;

import leetcode.树.TreeNode;

public class _226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        innerInvertTree(root);
        return root;
    }

    private void innerInvertTree(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tmp = node.left;
        node.left = node. right;
        node.right = tmp;

        innerInvertTree(node.left);
        innerInvertTree(node.right);
    }


    public static void main(String[] args) {
        _226_翻转二叉树 test = new _226_翻转二叉树();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(test.invertTree(root));

    }
}
