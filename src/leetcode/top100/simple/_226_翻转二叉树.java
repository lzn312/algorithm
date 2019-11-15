package leetcode.top100.simple;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * https://leetcode-cn.com/problems/invert-binary-tree
 * @see leetcode.树._226_翻转二叉树
 **/
public class _226_翻转二叉树 {
    /**
     * 这题做过 不过当时做的是镜像二叉树 但是我觉得他的思路也可以沿用
     * 结果好像不行，原则上就是交换两边的节点的左右节点就行了
     *
     **/
    public TreeNode invertTree(TreeNode root) {
        if (root == null ){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null )queue.offer(poll.right);

            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
        }
        return root;
    }
}
