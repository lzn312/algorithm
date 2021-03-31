package leetcode.bytedance;

import leetcode.树.TreeNode;

public class _236_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q)  return  root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 后序遍历 如果两个都不为空，按照base case root就是parent
        if (left != null && right != null) {
            return root;
        }

        // 如果两个都为空，按照base case 就是null
        if (left == null && right == null) {
            return null;
        }

        // 不然谁不为空，就是谁
        return left == null ? right : left;
    }
}
