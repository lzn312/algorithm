package leetcode.树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 **/
public class _105_从前序与中序遍历序列构造二叉树 {
//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]
    // 知道前序和中序可以构建二叉树

    /**
     * 第一反应就是做相同的事那么使用递归就好了,问题怎么使用递归
     * 要确定左右子树的范围边界然后在递归
     * 我们需要读取inorder的具体位置，为了快速确定root_val的位置可以考虑使用map结构快速获取下标
     **/

    public static void main(String[] args) {
        _105_从前序与中序遍历序列构造二叉树 test = new _105_从前序与中序遍历序列构造二叉树();
        System.out.println(test.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return innerBuildTree(preorder, 0, preorder.length -1 , inorder, 0, inorder.length -1);
    }

    private TreeNode innerBuildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int val = preorder[preStart];
        int index = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        int size = index - inStart;

        TreeNode node = new TreeNode();
        node.val = val;
        node.left = innerBuildTree(preorder, preStart + 1, preStart + size, inorder, inStart, index -1 );
        node.right = innerBuildTree(preorder, preStart + size + 1, preEnd, inorder, index + 1, inEnd);
        return node;
    }

//    buildTreeHelper(preorder, preStartIndex, preStopIndex,inorder, inorderStartIndex, inorderStopIndex);
}
