package leetcode.top100.simple;

public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {

            return val + ":" + next;
        }
}
