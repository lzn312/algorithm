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



    public static TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;

        return innerBuildTree(postorder, 0 , postorder.length -1,inorder, 0, inorder.length -1);
    }

    private static TreeNode innerBuildTree(int[] preorder, int preOrderStart, int preOrderEnd, int[] inorder, int inorderStart, int inorderEnd) {
        // baseCase
        if (preOrderStart > preOrderEnd) return null;
        // 找出值
        int rootVal =  preorder[preOrderEnd];
        int index = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inorderStart;
        TreeNode node = new TreeNode(rootVal);
        node.left = innerBuildTree(preorder, preOrderStart , preOrderStart + leftSize -1,
                inorder, inorderStart , index - 1);
        node.right = innerBuildTree(preorder, preOrderStart + leftSize , preOrderEnd -1 ,
                inorder, index + 1 , inorderEnd);
        return  node;
    }

    static TreeNode build(int[] inorder, int inStart, int inEnd,
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

    public static void main(String[] args) {
        System.out.println(buildTree1(new int[]{9,3,15,20,7},
                new int[]{9,15,7,20,3}));
    }
}
