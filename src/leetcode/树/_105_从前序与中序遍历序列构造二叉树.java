package leetcode.树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 **/
public class _105_从前序与中序遍历序列构造二叉树 {
    private static Map<Integer, Integer> map = new HashMap<>();
    // [4,2,1,3,6,5]+[1,2,3,4,5,6]
    // 知道前序和中序可以构建二叉树

    /**
     * 第一反应就是做相同的事那么使用递归就好了,问题怎么使用递归
     * 要确定左右子树的范围边界然后在递归
     * 我们需要读取inorder的具体位置，为了快速确定root_val的位置可以考虑使用map结构快速获取下标
     **/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // 构建递归函数
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * @param preorder          前序数组
     * @param preStartIndex     前序开始下标
     * @param preStopIndex      前序遍历截止下标
     * @param inorder           中序数组
     * @param inorderStartIndex 中序遍历开始下标
     * @param inorderStopIndex  中序遍历截止下标
     * @return TreeNode
     **/
    private TreeNode buildTreeHelper(int[] preorder, int preStartIndex, int preStopIndex, int[] inorder, int inorderStartIndex, int inorderStopIndex) {
        // 确定终止条件 当遍历下标指向都一样就停止遍历
        if (inorderStartIndex == inorderStopIndex) return null;
        // 得到根节点的值
        int val = preorder[preStartIndex];
        TreeNode treeNode = new TreeNode(val);
        // 获取根节点在中序数组index
        int inorderRootIndex = map.get(val);
        // 相减得到左节点数量
        int leftNum = inorderRootIndex - inorderStartIndex;

        // 开始递归
        treeNode.left = buildTreeHelper(preorder, preStartIndex + 1, preStartIndex + 1 + leftNum ,inorder, inorderStartIndex, inorderRootIndex);
        treeNode.right = buildTreeHelper(preorder, preStartIndex + 1 + leftNum, preStopIndex, inorder, inorderRootIndex + 1, inorderStopIndex);
        return treeNode;
    }

//    buildTreeHelper(preorder, preStartIndex, preStopIndex,inorder, inorderStartIndex, inorderStopIndex);
}
