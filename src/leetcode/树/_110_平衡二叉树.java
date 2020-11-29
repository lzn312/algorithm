package leetcode.树;

/**
 * @author Leezer
 * @date 2020/11/10 10:40 上午
 **/
public class _110_平衡二叉树 {



    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 如果左节点或者右节点不是平衡的则直接返回失败
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }


        // 求最大步长
        int leftHeight = maxHeight(root.left) + 1;
        int rightHeight = maxHeight(root.right) + 1;

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int maxHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    }


}
