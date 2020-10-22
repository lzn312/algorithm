package leetcode.链表;

import leetcode.top100.middle.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 **/
public class _21_合并两个有序链表 {


    /**
     * 这题比较简单，就是我们需要用一个哨兵节点就可以了。
     * 然后比较两个节点的大小
     **/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode sentinelNode = new ListNode(0);
        // 定义一个指针变脸
        ListNode tempNode = sentinelNode;

        while (l1 != null & l2 != null) {
            if (l1.val <= l2.val) {
                tempNode.next = l1;
                l1 = l1.next;
            }else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            tempNode = tempNode.next;
        }
        if (l1 != null) {
            tempNode.next = l1;
        }else {
            tempNode.next = l2;
        }
        return sentinelNode.next;

    }


}
