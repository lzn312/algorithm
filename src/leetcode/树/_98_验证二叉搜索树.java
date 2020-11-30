package leetcode.树;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 **/
public class _98_验证二叉搜索树 {

    /**
     * 这题感觉其实就是递归的解法，感觉也没啥说的
     **/
    public boolean isValidBST(TreeNode root) {


        return helper(root, null, null);


    }

    private boolean helper(TreeNode node, Integer left, Integer right) {
        if (node == null) {
            return true;
        }

        if (left != null && node.val <= left) {
            return false;
        }
        if (right != null && node.val >= right) {
            return false;
        }

        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}
