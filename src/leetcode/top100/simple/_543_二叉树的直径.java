package leetcode.top100.simple;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree
 **/
public class _543_二叉树的直径 {
    /**
     * 这题弄了半天我一直以为是求高度
     * 但是他说的是任意两个节点
     * 所以不是root的高度就是直径
     * 对于一个 节点的直径 = 左子树的高度 + 右子树的高度
     * 但可能每个节点的直径是不同的
     * 所以我们需要一个值更新最高的高度
     **/
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        depth(root);
        return max;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        // 更新最高的高度 l+r 为该节点的最大直径
        max = Math.max(leftDepth + rightDepth, max);
        // 返回节点左或右的节点高度
        return Math.max(leftDepth,rightDepth) + 1;
    }
}
