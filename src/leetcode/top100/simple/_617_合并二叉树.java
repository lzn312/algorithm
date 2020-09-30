package leetcode.top100.simple;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * https://leetcode-cn.com/problems/merge-two-binary-trees
 **/
public class _617_合并二叉树 {
    /**
     * 这题第一想法不难,直接使用队列 按照镜像对称的方式进行比较
     **/
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Stack<TreeNode> queue = new Stack<>();
        queue.push(t1);
        queue.push(t2);
        while (!queue.isEmpty()) {
            TreeNode t1Node = queue.pop();
            TreeNode t2Node = queue.pop();
            // 所有都不可能出现t1Node为空的情况 当t2Node为空的时候也没必要做下面的操作了.默认就为t1Node的值
            if (t2Node == null) {
                continue;
            }
            // 先改变当前节点的值

            t1Node.val += t2Node.val;
            // 再来照顾左右childRen 当时一直想不清楚怎么根据当前节点找到这个节点的左右子节点递归 但是现在想清楚了
            /**
             *  val只修改当前节点的val值(隐含条件是两个节点冲突了)
             *  而我们只需要接着考虑左右子节点可能出现的情况就行了
             *  下面的操作中是不存在我们要返回的t1Node为空所以可以放心修改
             **/
            // 如果t1Node.left为空 那么直接把它赋值为t2Node
            if (t1Node.left == null) {
                t1Node.left = t2Node.left;
            } else { // 隐含pushNode t1Node != null
                queue.push(t1Node.left);
                queue.push(t2Node.left);
            }

            if (t1Node.right == null) {
                t1Node.right = t2Node.right;
            } else {
                queue.push(t1Node.right);
                queue.push(t2Node.right);
            }

        }
        return t1;
    }
}
