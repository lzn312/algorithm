package leetcode.链表;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class _206_反转链表 {



     private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
           return "{ val = " + val + ",next = "  + next + "}";
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

    private ListNode reverse(ListNode head, ListNode end){
         ListNode prev = null;
         ListNode cur = head;
         while (cur != end) {
             ListNode nxt = cur.next;
             cur.next = prev;
             prev = cur;
             cur = nxt;
         }
         return prev;
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



    public ListNode reverseNode(ListNode node ) {
        if (node == null || node.next == null) {
            return node;
        }


        return reverse(node, null);

    }


    public static void main(String[] args) {
        _206_反转链表 test = new _206_反转链表();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next .next.next= new ListNode(4);
        root.next .next.next.next= new ListNode(5);
        root.next .next.next.next.next= new ListNode(6);
        root.next .next.next.next.next.next= new ListNode(7);

        System.out.println(test.reverseNode(root));
    }
}
