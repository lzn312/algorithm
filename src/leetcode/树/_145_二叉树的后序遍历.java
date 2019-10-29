package leetcode.树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 **/

public class _145_二叉树的后序遍历 {

    //后序遍历大体和前序遍历挺像的 但是要注意的是后序遍历是结果往前添加
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<TreeNode> tree = new Stack<>();

        tree.push(root);

        while(!tree.isEmpty()){
            TreeNode poll = tree.pop();
            result.add(0,poll.val);

            if(poll.left != null) tree.push(poll.left);
            if(poll.right != null) tree.push(poll.right);
        }
        return result;
    }
}
