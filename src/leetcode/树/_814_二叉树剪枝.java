package leetcode.树;

/**
 *给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 示例1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 *
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 *
 * 示例2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 *
 *
 *
 * 示例3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 *
 *
 * 说明:
 *
 * 给定的二叉树最多有 100 个节点。
 * 每个节点的值只会为 0 或 1 。
 *
 *
 **/
public class _814_二叉树剪枝 {


    /**
     * 这题其实也就是递归处理就行了，
     * 如果当前节点为0，并且左右子节点为null就可以删除了，因为从叶子节点进行处理时，如果包含1的肯定能留下来
     *
     **/
    public TreeNode pruneTree(TreeNode root) {
        return pruneNode(root);
    }

    private TreeNode pruneNode(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.left = pruneNode(node.left);
        node.right = pruneNode(node.right);
        if (node.val == 0 && node.left == null && node.right == null) {
            return null;
        }
        return node;
    }

}
