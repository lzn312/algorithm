package leetcode.递归;

import leetcode.树.TreeNode;

/**
 * @author Leezer
 * @date 2020/12/23 9:53 上午
 **/
public class _111_二叉树的最小深度 {


    /**
     * 这题和求最大路径是一致的,我们一直沿路径遍历，遍历的结果也就是左子树到叶子节点的最小值，和右子树到叶子节点的最小值的最小值 + root的深度
     * 这点的困难点在于我们的递归结束条件需要确认，只有左右子节点不为空时返回其最小值
     * 如果其中某个节点为空时，则选取另外一个节点数据返回
     **/
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = minDepth(root.left);


        int rightHeight = minDepth(root.right);

        if (root.left == null){
            return rightHeight + 1;
        }
        if (root.right == null) {
            return leftHeight + 1;
        }
        return Math.min(leftHeight, rightHeight) + 1;

    }
}
