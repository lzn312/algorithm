package leetcode.top100.simple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 **/
public class _101_对称二叉树 {
    /**
     * 既然是对称二叉树,那么肯定需要满足几点:
     *  1. 子节点数量一定是2的倍数 否则不是镜像对称
     *  2. 类似于有效括号一样,可以用栈来对比其值是否相等
     *  但是我的时间复杂度就比较高了,所以得采用另外一种做法,那就是添加两遍 比对两个节点的值 和是否对称
     **/
    public boolean isSymmetric(TreeNode root) {
        if (root == null ) return false;
        return iterator(root);
    }
    // 迭代思想实现
    private boolean iterator(TreeNode root){
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        // 添加进入两个 root进入队列
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            //如果两个节点都不存在那么久认为其对称且为子节点
            if (left == null && right == null){
                continue;
            }
            //如果两个节点有一个不存在那么久认为不是镜像对称
            if (left == null || right == null){
                return false;
            }
            //到这一步可以比较两个的值了
            if (left.val != right.val) return false;
            // 值相等之后就镜像添加节点值
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }


    // 递归思想实现 其实和迭代是一样的思想,都是镜像对比两个节点是否存在还有值
    private boolean isMirror(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null ){
            return false;
        }
        return (left.val == right.val) && isMirror(left.left,right.right) && isMirror(left.right, right.left);
    }

    private static class  TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
