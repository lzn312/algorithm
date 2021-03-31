package leetcode.bytedance;

import leetcode.top100.simple.ListNode;

public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode prevA = headA;
        ListNode prevB = headB;

        while (prevA != prevB) {
            prevA = prevA == null ? headB : prevA.next;
            prevB = prevB == null ? headA : prevB.next;
        }
        return prevA;
    }
}
