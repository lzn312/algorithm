package leetcode.链表;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class _206_反转链表 {
    private ListNode listNode;


     private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode curr = this;
            StringBuilder stringBuilder = new StringBuilder();
            while (curr.next != null){
                stringBuilder.append(val).append(",");
                curr = curr.next;
            }
            return stringBuilder.toString();
        }
    }

    // 递归
    public  ListNode reverseList(ListNode head) {
        // 只有一个节点或者head为空 那么就返回本身就行
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public ListNode reverseList1(ListNode head) {
        // 使用哨兵节点来完成
        ListNode prev = null;
        ListNode curr =  head;

        while(curr != null){
            // 找出下一个节点指针
            ListNode temp = curr.next;
            // 把当前指正的下一节点指向上一节点
            curr.next = prev;
            // 上一节点就是当前节点
            prev = curr;
            // 当前节点指向下一节点
            curr = temp;
        }

        return prev;
    }


    public static void main(String[] args) {
        _206_反转链表 test = new _206_反转链表();
        System.out.println(test.listNode);
    }
}
