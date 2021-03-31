package leetcode.bytedance;

import leetcode.top100.simple.ListNode;

public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return  true;
        }

        return false;
    }


}
