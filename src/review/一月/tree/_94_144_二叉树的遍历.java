package review.一月.tree;

import leetcode.树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _94_144_二叉树的遍历 {



    /**
     * 中序遍历
     **/
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        innerInorderTraversal(root, res);
        return res;
    }

    private void innerInorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null ) {
            return;
        }
        innerInorderTraversal(node.left, res);
        res.add(node.val);
        innerInorderTraversal(node.right, res);
    }


    /**
     * 前序遍历
     **/
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        innerPreorderTraversal(root, res);
        return res;
    }

    private void innerPreorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null ) {
            return;
        }
        res.add(node.val);
        innerPreorderTraversal(node.left, res);
        innerPreorderTraversal(node.right, res);
    }


    public static void main(String[] args) {
        _94_144_二叉树的遍历 test = new _94_144_二叉树的遍历();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(test.inorderTraversal(root));
    }
}
