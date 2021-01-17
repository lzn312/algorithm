package leetcode.树;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 **/

public class _94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        innerInorderTraversal1(result,root);
        return result;
    }
    // 中序遍历就是考虑先访问左上右 可以使用递归来做

    private void innerInorderTraversal(List<Integer> result ,TreeNode node){
        if (node == null)return;
        innerInorderTraversal(result, node.left);
        result.add(node.val);
        innerInorderTraversal(result, node.right);
    }
    // 中序遍历就是考虑先访问左上右 可以使用非递归来做
    private void innerInorderTraversal1(List<Integer> result ,TreeNode node){

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = node;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            p = tmp.right;
        }


    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//

        _94_二叉树的中序遍历 so = new _94_二叉树的中序遍历();
        List<Integer> integers = so.inorderTraversal(root);
        System.out.println(integers);

    }
}
