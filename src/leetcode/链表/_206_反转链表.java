package leetcode.链表;
/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 **/
public class _206_反转链表 {
    private ListNode listNode;


    public  class ListNode {
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
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    // 非递归版本
    public  ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        // 明确知道我们只能拿到head节点。 那么肯定存在需要遍历和需要一个新的newNode节点
        ListNode newHead = null;
        // 结束条件 不为空则继续操作
        while (head != null){
            // 首先定义一个tmp节点指向head的next节点
            ListNode tmp = head.next;
            // 把head的next指向newHead
            head.next = newHead;
            // 这样newHead就完成了 取出当前的head
            newHead = head;
            // 把head指向tmp
            head = tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        _206_反转链表 test = new _206_反转链表();
        System.out.println(test.listNode);
    }
}
