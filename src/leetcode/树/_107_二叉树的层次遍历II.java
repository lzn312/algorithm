package leetcode.树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 **/

public class _107_二叉树的层次遍历II {
    //我第一想法是拿到正序的结果然后反过来排就是了 在考虑考虑
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        List<Integer> level = new ArrayList<>();
        int levelSize = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelSize--;
            level.add(poll.val);

            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);

            if (levelSize == 0) {
                levelSize = queue.size();
                result.add(level);
                level = new ArrayList<>();
            }
        }
        Collections.reverse(result);
        return  result;
    }
}
