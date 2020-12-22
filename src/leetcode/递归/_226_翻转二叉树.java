package leetcode.递归;

import leetcode.树.TreeNode;

/**
 *翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 **/
public class _226_翻转二叉树 {


    public TreeNode invertTree(TreeNode root) {

        // 我们先使用递归来做，递归其实就是完几个遍历，我们看一看题目要求
        innerInvertTree(root);
        return root;
    }

    private void innerInvertTree(TreeNode root) {

        // termniate
        if ( root == null){
            return;
        }

        // process
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        //recursion
        invertTree(root.left);
        invertTree(root.right);

    }
}
