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
 *
 **/
public class _102_二叉树的层序遍历 {
    /**
     * 其实这一块和深度优先搜索挺像的，我感觉没啥区别
     **/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result =new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        int dep = 0;
        int levelSize = 1;
        List<Integer> rootList = new ArrayList<>(levelSize);
        result.add(rootList);

        while (!nodeStack.isEmpty()) {

            TreeNode node = nodeStack.pop();
            result.get(dep).add(node.val);

            levelSize--;
            if (node.right != null) {
                nodeStack.push(node.right);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
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


    public List<List<Integer>> levelOrder1(TreeNode root ){
        List<List<Integer>> allRes = new ArrayList<>();

        if (root == null) {
            return allRes;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);


        while (!nodes.isEmpty()){
            int resSize = nodes.size();

            List<Integer> currentRes = new ArrayList<>();

            // process
            for (int i = 0; i < resSize; i++) {
                TreeNode node = nodes.poll();
                if (node != null){
                    currentRes.add(node.val);

                    if (node.left != null){
                        nodes.offer(node.left);
                    }

                    if (node.right != null){
                        nodes.offer(node.right);
                    }
                }
            }

            allRes.add(currentRes);
        }
        return allRes;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);


    }
}
