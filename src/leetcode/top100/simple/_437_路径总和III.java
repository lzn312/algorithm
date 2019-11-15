package leetcode.top100.simple;

import leetcode.树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * https://leetcode-cn.com/problems/path-sum-iii
 **/
public class _437_路径总和III {
    /**
     * 遇到树的问题一般是需要转换为各种遍历去做
     * 我一开始以为这一题要用动态规划来做，按理说是应该。但是找不到合适的遍历条件
     * 其实想法倒是不错不过思路还有问题:
     *    XXX 客观的来讲就是应该遍历到每个节点,然后求每个节点深度遍历的结果的综合
     **/
    public static  int pathSum(TreeNode root, int sum) {
        if (root == null || sum<= -1000000 || sum >= 1000000){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            count += helper(poll, sum, 0);
            if (poll.left != null ) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }
        return count;
    }

    /**
     * @param node  当前节点
     * @param sum 求和结果
     * @param curSum 当前结果累加和
     * @return 路径数
     **/
    private static int helper(TreeNode node, int sum, int curSum){
        int ans = 0;
        curSum += node.val;
        if (curSum == sum) ++ans;
        if (node.left != null){
            ans += helper(node.left, sum, curSum);
        }
        if (node.right != null){
            ans += helper(node.right, sum, curSum);
        }
        return ans;
    }

    public static void main(String[] args) {
//        [10,5,-3,3,2,null,11,3,-2,null,1]
        TreeNode ro = new TreeNode(10);
        TreeNode l1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(-3);
        TreeNode l2 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(11);
        TreeNode r3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(-2);
        TreeNode r4 = new TreeNode(1);
        ro.left = l1;
        ro.right = r1;
        l1.left = l2;
        l1.right = r2;
        r1.right = l3;
        l2.left = r3;
        l2.right = l4;
        r2.right = r4;
        System.out.println(pathSum(ro,8));

    }
}
