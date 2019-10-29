package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 *https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 **/

public class _104_二叉树的最大深度 {
    //深度就是求根节点到叶子节点的距离 最大深度=树的深度=树的高度 那么我们可以考虑求树的高度怎么做
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return depth(root);
    }


    // 递归 其实可以转换为求某个节点的高度 那么就可以转换为 求 当前节点固定为1的值 + max（左节点的深度, 右节点的深度);
    public  int depth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(depth(node.left),depth(node.right));
    }

    // 非递归 其实就是想我们在按照层遍历所有节点,当遍历完这一层的时候，那么节点深度就+1
    public int depth1(TreeNode node){
        if (node == null) return 0;

        // 使用层序遍历来做
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        // 定义depth值和levelSize
        int depth = 0;
        int levelSize = 1;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();

            // levelSize --;
            levelSize--;

            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);

            if (levelSize == 0){
                levelSize = queue.size();
                depth++;
            }
        }
        return depth;
    }

}
