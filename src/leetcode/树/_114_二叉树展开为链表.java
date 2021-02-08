package leetcode.树;


import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 *  
 *
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 *
 **/
public class _114_二叉树展开为链表 {

    public void flatten1(TreeNode root) {
        TreeNode sentinelNode = root;
        Stack<TreeNode > stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop != sentinelNode) {
                sentinelNode.left = null;
                sentinelNode.right = pop;
                sentinelNode = pop;
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    /**
     * 1、将root的左子树和右子树拉平。
     *
     * 2、将root的右子树接到左子树下方，然后将整个左子树作为右子树。
     *
     * 我们主要难点是在于如何把它拉平
     **/
    public void flatten(TreeNode node) {

        // terminator
        if (node == null) {
            return;
        }

        // 拉平左右子树
        flatten(node.left);
        flatten(node.right);


        // 连接左右子树,左右子树已经被拉平
        TreeNode left = node.left;
        TreeNode right = node.right;

        // 处理当前节点的左右子树
        node.left = null;
        node.right = left;


        // 将原先的右子树接到当前右子树的末端
        TreeNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        _114_二叉树展开为链表 so = new _114_二叉树展开为链表();
        so.flatten(root);
        System.out.println(root);
    }
}
