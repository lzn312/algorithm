package leetcode.everyday;


import leetcode.top100.middle.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 *
 *
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 **/
public class _142_环形链表II {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        // 这个时候slow = nb，说明slow走了n倍的b步了。
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(0);
        ListNode head3 = new ListNode(-4);


        head.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head1);

        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(2);

        h.setNext(h1);


        head.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head1);
        _142_环形链表II test = new _142_环形链表II();

//        System.out.println(test.detectCycle(head).val);
        System.out.println(test.detectCycle(h).val);

    }
}
