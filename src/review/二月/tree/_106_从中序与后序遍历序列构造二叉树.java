package review.二月.tree;

import leetcode.树.TreeNode;

public class _106_从中序与后序遍历序列构造二叉树 {


    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder.length != inorder.length || inorder.length < 1) {
            return null;
        }

//        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length-1);
        return build1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length-1);

    }

    TreeNode build1(int[] inorder, int inStart, int inEnd,
                    int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    private TreeNode build(int[] postorder, int postLo, int postHi, int[] inorder, int inLo, int inHi) {
        if (postLo > postHi) {
            return null;
        }

        //op
        int rootVal = postorder[postHi];
        int nodeIndex = 0;
        for (int i = inLo; i <= inHi; i++) {
            if (inorder[i] == rootVal) {
                nodeIndex = i;
                break;
            }
        }
        int leftSize = nodeIndex - inLo;

        TreeNode node = new TreeNode(rootVal);
        node.left = build(postorder, postLo, postLo + leftSize - 1, inorder, inLo, nodeIndex - 1);
        node.right = build(postorder, postLo + leftSize, postHi - 1, inorder, nodeIndex + 1, inHi);

        return node;
    }





}
