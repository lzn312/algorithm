package leetcode.树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 **/

public class _106_从中序与后序遍历序列构造二叉树 {
    private static Map<Integer, Integer> map = new HashMap<>();
    /**
     * 第一反应就是做相同的事那么使用递归就好了,问题怎么使用递归
     * 要确定左右子树的范围边界然后在递归
     * 我们需要读取inorder的具体位置，为了快速确定root_val的位置可以考虑使用map结构快速获取下标
     **/
    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 构建递归函数
        return buildTreeHelper(postorder, 0, postorder.length -1 , inorder, 0, inorder.length -1 );
    }

    /**
     * @param postorder          后序数组
     * @param postStartIndex     后序开始下标
     * @param postStopIndex      后序遍历截止下标
     * @param inorder           中序数组
     * @param inorderStartIndex 中序遍历开始下标
     * @param inorderStopIndex  中序遍历截止下标
     * @return TreeNode
     **/
    private TreeNode buildTreeHelper(int[] postorder, int postStartIndex, int postStopIndex, int[] inorder, int inorderStartIndex, int inorderStopIndex) {
        // 确定终止条件 当遍历下标指向都一样就停止遍历
        if (inorderStartIndex == inorderStopIndex) return null;
        // 得到根节点的值
        int val = postorder[postStopIndex];
        TreeNode treeNode = new TreeNode(val);
        // 获取根节点在中序数组index
        int inorderRootIndex = map.get(val);


        // 开始递归
        treeNode.left = buildTreeHelper(postorder, postStartIndex , postStopIndex - inorderStopIndex + inorderRootIndex - 1 , inorder, inorderRootIndex -1 ,  postStartIndex );
        treeNode.right = buildTreeHelper(postorder, postStopIndex - inorderStopIndex + inorderRootIndex - 1 + 1, postStopIndex -1 , inorder,inorderRootIndex + 1  ,  inorderStopIndex);
        return treeNode;
    }
}
