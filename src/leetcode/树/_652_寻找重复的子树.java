package leetcode.树;

import java.util.*;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 **/
public class _652_寻找重复的子树 {

    Map<String,Integer> containsNode = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        innerFindSubTree(root,nodes);

        return nodes;
    }

    private String innerFindSubTree(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return "#";
        }

        String left = innerFindSubTree(node.left, nodes);
        String right = innerFindSubTree(node.right, nodes);
        String subTree = left + ',' + right + ',' + node.val;

        if (containsNode.containsKey(subTree)) {
            if (containsNode.get(subTree) == 1) {
                nodes.add(node);
            }
            containsNode.put(subTree, containsNode.get(subTree) + 1);
        }else {
            containsNode.put(subTree, 1);
        }
        return subTree;
    }
}
