
public class PalindromeLink {
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
    public boolean isPalindrome1(ListNode head){
        // 如果是回文链表一定能找到中点
        if (head == null || head.next == null){
            return true;
        }
        ListNode  middle = head;
        ListNode heail = head;
        while (heail != null && heail.next != null){
            middle = middle.next;
            heail = heail.next.next;
        }
        ListNode reverse = null;
        ListNode temp;
        while (middle != null){
            temp = middle.next;
            middle.next = reverse;
            reverse = middle;
            middle = temp;
        }

        while (reverse != null){
            if (reverse.val != head.val) return false;
            head = head.next;
            reverse = reverse.next;
        }
        return true;
   }
}
