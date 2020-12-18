package leetcode.top100.hard;

import leetcode.top100.middle.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *  
 **/
public class _23_合并K个升序链表 {

    static class SelectNode implements Comparable<SelectNode> {
        int val;
        ListNode curr;

        public SelectNode(int val, ListNode curr) {
            this.val = val;
            this.curr = curr;
        }

        @Override
        public int compareTo(SelectNode o) {
            return this.val - o.val;
        }
    }

    /**
     * 通过最小堆来进行链表间的排序
     **/
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<SelectNode> queue = new PriorityQueue<>();
        ListNode sentinelNode = new ListNode(-1);
        ListNode tempNode = sentinelNode;

        /// 插入第一个节点，进行比较。
        for (ListNode node : lists) {
            if (node != null){
                queue.offer(new SelectNode(node.val, node));
            }
        }


        while (!queue.isEmpty()){
            SelectNode node = queue.poll();
            tempNode.next = node.curr;
            tempNode = tempNode.next;
            if (node.curr.next != null){
                queue.offer(new SelectNode(node.curr.next.val, node.curr.next));
            }

        }


        return sentinelNode.next;
    }
}
