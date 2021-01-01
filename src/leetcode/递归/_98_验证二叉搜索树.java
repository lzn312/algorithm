package leetcode.递归;

import leetcode.树.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 *

 **/
public class _98_验证二叉搜索树 {



    private TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {

       // 我们可以换一个思路，来使用中序遍历的思想完成，但是中序遍历的思想有一个前提，就是我们遍历的结果，需要和上一个节点进行比较，
        //  否则可能出现结果满足最小单元的二叉搜索树规则，但不满足整颗二叉搜索树规则


//        // 我们使用迭代栈来解决这一题
//        Stack<TreeNode> stack = new Stack<>();
//
//        while ( !stack.isEmpty() || root != null){
//            // 找到最左节点
//            while (root != null){
//                stack.push(root);
//                root = root.left;
//            }
//
//            // 操作数据
//            root = stack.pop();
//            if (pre != null && root.val <= pre.val) return false;
//            pre = root;
//            root = root.right;
//        }
//        return true;

        return innerIsValidBST(root);
    }

    private boolean innerIsValidBST(TreeNode root) {

        // terminate
        if (root == null) {
            return true;
        }

        boolean left = innerIsValidBST( root.left);

        if (pre != null && root.val <= pre.val){
            return false;
        }
        this.pre = root;

        boolean right = innerIsValidBST(root.right);

        return left && right;
    }


    public static void main(String[] args) {
        _98_验证二叉搜索树 v = new _98_验证二叉搜索树();
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        v.isValidBST(s);
    }
}
