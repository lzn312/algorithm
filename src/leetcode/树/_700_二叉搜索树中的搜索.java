package leetcode.树;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * <p>
 * 例如，
 * <p>
 * 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和值: 2
 * 你应该返回如下子树:
 * <p>
 * 2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * [62,2,93,null,30,null,null,15,null,null,null]
 * 62
 * 2 93
 * null 30 null null
 * 15
 **/
public class _700_二叉搜索树中的搜索 {

    /**
     * 二叉搜索树这个搜索值其实挺好判断的，如果值等于该节点的值，则返回该Node。
     * 如果它小于当前节点的值，则往左搜索，如果左搜索节点值大于其，则返回null。
     * 如果它大于当前节点的值，则往右搜索，如果右搜索节点值小于其，则返回null。
     **/
    public TreeNode searchBST(TreeNode root, int val) {

        // 定义哨兵节点
        TreeNode sentinelNode = root;

        while (sentinelNode != null) {
            if (sentinelNode.val == val) {
                return sentinelNode;
            } else if (val < sentinelNode.val) {
                sentinelNode = sentinelNode.left;
            } else {
                sentinelNode = sentinelNode.right;
            }
        }

        return null;
    }
}
