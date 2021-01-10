package leetcode.链表;


import leetcode.top100.middle.ListNode;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 **/
public class _86_分隔链表 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这题其实就是普通的链表指针移动的问题，我们应该利用临时指针来重新组织链表
        ListNode smallNode = new ListNode(-1);
        ListNode smallHeadNode = smallNode;

        ListNode largeNode = new ListNode(-1);
        ListNode largeHeadNode = largeNode;



        while (head != null ){
            if (head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            }else {
                largeNode.next = head;
                largeNode = largeNode.next;
            }
            head = head.next;
        }


        largeNode.next = null;
        smallNode.next = largeHeadNode.next;

        return smallHeadNode.next;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.setNext(new ListNode(4));
        head.next.setNext( new ListNode(3));
        head.next.next.setNext( new ListNode(2));
        head.next.next.next.setNext( new ListNode(5));
        head.next.next.next.next.setNext( new ListNode(2));


        _86_分隔链表 test = new _86_分隔链表();
        System.out.println(test.partition(head, 3));
    }
}
