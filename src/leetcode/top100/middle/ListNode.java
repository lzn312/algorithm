package leetcode.top100.middle;

public class ListNode {
    int val;
    public ListNode next;
    ListNode(int x) {
        val = x;
    }


    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
