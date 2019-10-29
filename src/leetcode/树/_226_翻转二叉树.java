package leetcode.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 **/
public class _226_翻转二叉树 {
    // 其实核心思想就是把每个左右两边的节点交换。 所以只要遍历了每个节点交换左右两边节点就可以了
    // 我们可以使用递归: 前中后序遍历
    //         非递归: 层序遍历
    public TreeNode invertTree(TreeNode root) {
         if (root == null) return null;
        innerInvertTree(root);
         return root;
    }

    private void innerInvertTree(TreeNode node){
         if (node == null){
             return;
         }
        innerInvertTree(node.left);
        innerInvertTree(node.right);
         TreeNode temp = node.left;
         node.left = node.right;
         node.right = temp;
    }


    private void innerInvertTreeWithLevel(TreeNode root){
        if (root == null){
            return;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
        }
    }

}
