package leetcode.树;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * 示例:
 *
 * 输入:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * 输出: 6
 *
 **/
public class _222_完全二叉树的节点个数_ {

    /**
     * 这题没啥思路，首先要清楚的是完全二叉树的定义
     * 其次就是知道完全二叉树节点和书高之间的关系 2^h -1  如果统计出来再加上root节点就是 2^h 了
     **/
    public int countNodes(TreeNode node) {

        if (node == null) {
            return 0;
        }


        int leftHeight = maxHeight(node.left);
        int rightHeight = maxHeight(node.right);


        if (leftHeight == rightHeight) {
            return countNodes(node.right) + (1 << leftHeight);
        } else {
            return countNodes(node.left) + (1 << rightHeight);
        }
    }

    private int maxHeight(TreeNode node) {
        int height = 0 ;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
