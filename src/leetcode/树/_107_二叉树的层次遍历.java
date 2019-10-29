package leetcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 **/

public class _107_二叉树的层次遍历 {

    /**
     * 就是层序遍历的一些变种 so easy (*^▽^*)
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
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
        return result;
    }

    // 还可以使用递归的方式来解决
    List<List<Integer>> levels = new ArrayList<>();

    private void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }

}
