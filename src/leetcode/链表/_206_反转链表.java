package leetcode.链表;
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
            StringBuilder stringBuilder = new StringBuilder();
            while (next != null){
                stringBuilder.append(val).append(",");
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


    public static void main(String[] args) {
        _206_反转链表 test = new _206_反转链表();
        System.out.println(test.listNode);
    }
}
