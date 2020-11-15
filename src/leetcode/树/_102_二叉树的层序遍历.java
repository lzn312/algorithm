package leetcode.树;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 **/
public class _102_二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.offer(root);

        int dep = 0;
        int levelSize = 1;
        List<Integer> rootList = new ArrayList<>(levelSize);
        result.add(rootList);

        while (!nodeStack.isEmpty()) {

            TreeNode node = nodeStack.poll();
            result.get(dep).add(node.val);

            levelSize--;

            if (node.left != null) {
                nodeStack.offer(node.left);
            }
            if (node.right != null) {
                nodeStack.offer(node.right);
            }

            if (levelSize == 0) {
                levelSize = nodeStack.size();
                dep++;
                if (!nodeStack.isEmpty()) {
                    List<Integer> nodeList = new ArrayList<>(levelSize);
                    result.add(nodeList);
                }
            }
        }


        return result;
    }
}
