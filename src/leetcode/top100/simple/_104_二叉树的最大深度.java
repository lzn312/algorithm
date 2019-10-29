package leetcode.top100.simple;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @see leetcode.树._104_二叉树的最大深度
 **/
public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        // 其实就是求树节点的高度
        //非递归
        return depth1(root);
    }
    private int depth1(TreeNode node){
        if (node == null )return 0;
        return 1 + Math.max(depth1(node.left), depth1(node.right));
    }
    private int  depth(TreeNode node){
        if (node == null){
            return 0;
        }else {
            Queue<TreeNode> queue = new LinkedList<>();
            int height = 1;
            int levelSize =1 ;
            queue.offer(node);
            while (!queue.isEmpty() ){
                TreeNode poll = queue.poll();
                levelSize--;
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (levelSize == 0){
                    levelSize = queue.size();
                    height++;
                }
            }
            return height;
        }
    }
}
