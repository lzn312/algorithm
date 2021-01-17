package review.一月.recursion;

import leetcode.树.TreeNode;

public class _104_二叉树的最大深度 {

    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return dfs(root);

    }


    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max( dfs(node.left) + 1,  dfs(node.right) + 1);
    }


    public static void main(String[] args) {

    }



}
