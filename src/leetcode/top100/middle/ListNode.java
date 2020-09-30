package leetcode.top100.middle;

public class ListNode {
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
