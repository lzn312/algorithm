package leetcode.链表;
/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 **/
public class _141_环形链表 {

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


    /**
     * 2.链表中环的检测
     * 现象:             [data4][next]
     *                         |       ↖
     *                         v
     * [data1][next] -> [data2][next] -> [data3][next]
     *
     * 逻辑:
     * 使用快慢指针来进行判断.
     * 如果存在快慢指针相等时就有环
     **/
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while ( fast != null && fast.next != null){
            if (fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
