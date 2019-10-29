package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 **/

public class _662_二叉树最大宽度 {

    public int widthOfBinaryTree(TreeNode root) {

        /**
         * 竟然要得到宽度 那么就考虑使用层序遍历来做
         **/
        if (root == null )return  0;
        Queue<TreeNode> queue = new LinkedList<>();
        // 最小有一个根节点
        int width = 1;
        int levelSize = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            width++;
        }
        // TODO 待定
        return 0;
    }
}
