package leetcode.深度及广度优先;

import leetcode.树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 **/
public class _515_在每个树行中找最大值 {





    public List<Integer> largestValues(TreeNode root) {

        if (root == null ) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while(!nodes.isEmpty()) {
            int rowSize = nodes.size();
            int minRowVal =  Integer.MIN_VALUE;
            for (int i = 0; i < rowSize; i++) {
                TreeNode node = nodes.poll();
                minRowVal = Math.max(minRowVal, node.val);
                if (node.left != null ) {
                    nodes.add(node.left);
                }
                if (node.right != null ) {
                    nodes.add(node.right);
                }
            }
            if (minRowVal != Integer.MIN_VALUE) {
                res.add(minRowVal);
            }
        }

        return res;

    }


}
