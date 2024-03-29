package leetcode.bytedance;


import leetcode.树.TreeNode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 *
 *
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *  
 *
 * 提示：
 *
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 *
 **/
public class _124_二叉树中的最大路径和 {

    // 使用全局变量存储结果
    Integer maxRes = 0;
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return maxRes;
    }

    public int postOrder(TreeNode root) {
        // base case
        if (root == null) return 0;

        // 如果为负数，说明收益不高，直接为0
        int left = Math.max(postOrder(root.left), 0 );
        int right = Math.max(postOrder(root.right), 0);
        // 最大结果，就是这个元祖
        maxRes = Math.max(maxRes, root.val + left + right);
        // 返回上层，根节点到其中某一个节点的值，或者就是根节点的值
        return root.val + Math.max(left,right);
    }

}
