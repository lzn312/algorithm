
public class _环形链表 {
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

    public boolean hasCycle(ListNode head) {
        // 使用快慢指针来做
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null ){
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }



}
