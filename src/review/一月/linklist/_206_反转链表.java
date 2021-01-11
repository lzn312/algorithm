package review.一月.linklist;

import leetcode.top100.simple.ListNode;

public class _206_反转链表 {


    public ListNode reverseList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }


        ListNode curryNode = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = curryNode;
            curryNode = head;
            head = nextNode;
        }

        return curryNode;
    }
}
