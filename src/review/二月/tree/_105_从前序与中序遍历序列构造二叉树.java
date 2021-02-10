package review.二月.tree;

import leetcode.树.TreeNode;

public class _105_从前序与中序遍历序列构造二叉树 {


    /**
     * 这一题其实我们可以联想一下其实就是递归的一些起源，所以说二叉树真的是学习任何一种算法的好数据结构
     * 1. 确认root节点值（通过前序遍历）
     * 2. 确认root左右节点边界（通过中序遍历） preorder的移动可以通过inorder： rootIndex + inorderRootLeftSize 来确定（小技巧）
     * 3. 通过上述方法递归。
     **/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

        return build(preorder, 0, preorder.length-1,inorder, 0, inorder.length);

    }

    private TreeNode build(int[] preorder, int preLo, int preHi, int[] inorder, int inLo, int inHi) {
        // terminator
        if (preLo > preHi) {
            return null;
        }
        // op
        TreeNode node = new TreeNode(preorder[preLo]);
        int nodeIndex = inLo;
        for (int i = inLo; i <= inHi ; i++) {
            if (inorder[i] == preorder[preLo]) {
                nodeIndex = i;
                break;
            }
        }
        int leftSize = nodeIndex - inLo;

        // 处理left节点数据
        node.left = build(preorder, preLo + 1, preLo + leftSize, inorder, inLo, nodeIndex -1 );
        node.right = build(preorder, preLo + leftSize + 1, preHi, inorder, nodeIndex + 1, inHi );
        return node;
    }


    public static void main(String[] args) {
        //[3,9,20,15,7]
        //[9,3,15,20,7]
        _105_从前序与中序遍历序列构造二叉树 test = new _105_从前序与中序遍历序列构造二叉树();
        System.out.println(test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

}
