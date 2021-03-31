package leetcode.bytedance;

import leetcode.树.TreeNode;


/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 通过次数171,971提交次数247,547
 *
 **/
public class _105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return innerBuildTree(preorder, 0 , preorder.length -1 , inorder, 0,inorder.length -1);

    }

    private TreeNode innerBuildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        // base case
        if (pStart > pEnd) return null;

        // 找到节点
        int index = 0;
        for (int i = iStart; i <= iEnd;i++) {
            if (inorder[i] == preorder[pStart]) {
                index = i;
                break;
            }
        }

        int leftSize = index - iStart;

        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = innerBuildTree(preorder, pStart+1, pStart + leftSize, inorder,iStart, index -1 );
        root.right = innerBuildTree(preorder, pStart + leftSize + 1, pEnd, inorder,index+1, iEnd);
        return root;
    }
}
