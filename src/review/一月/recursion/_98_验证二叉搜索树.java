package review.一月.recursion;

import leetcode.树.TreeNode;

public class _98_验证二叉搜索树 {

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {


        return helper(root);


    }

    private boolean helper(TreeNode node) {
        if ( node == null ){
            return true;
        }
        if (!helper(node.left)){
            return false;
        }
        if (node.val <= pre) {
            return false;
        }
        pre = node.val;
        return helper(node.right);

    }
}
