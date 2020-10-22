package leetcode.链表;

import leetcode.top100.middle.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 **/
public class _2_两数相加 {


    /**
     * 这题其实和数组的两数相加是一样的，而且一来就减小了难度，使用逆序排序。
     * 现在我们只需要注意一下边界值，使用一个哨兵节点来解决就行了
     **/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 定义一个flag看是否溢出，
        boolean overFlow = false;

        // 定一个哨兵节点用来返回数据
        ListNode sentinelNode = new ListNode(0);
        // 定一个随时移动的node
        ListNode tempNode = sentinelNode;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }

            if (l2 != null) {
                l2Val = l2.val;
            }
            int res = l1Val + l2Val;
            if (overFlow) {
                res += 1;
                overFlow = false;
            }
            if (res  >= 10) {
                res = 0;
                overFlow = true;
            }

            tempNode.next = new ListNode(res);

            tempNode = tempNode.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return sentinelNode.next;

    }
}
