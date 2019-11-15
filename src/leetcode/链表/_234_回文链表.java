package leetcode.链表;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * https://leetcode-cn.com/problems/palindrome-linked-list
 **/
public class _234_回文链表 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            while (next != null) {
                stringBuilder.append(val).append(",");
            }
            return stringBuilder.toString();
        }
    }

    /**
     * 这题第一反应就是就是和有效括号是一样的
     * 但是缺点就是如何考虑空间复杂度为O(1)呢？
     * XXX test access
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     **/
    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (temp != null) {
            if (stack.pop() != temp.val) {
                break;
            }
            temp = temp.next;
        }
        return stack.isEmpty();
    }

    /**
     * 其实也有想到反转链表来做，但是反转链表后的时间复杂度好像不是O(n)所以没用他来做
     * 但是其实他时间复杂度就是O(n)
     * 思路:
     * 1. 找到链表中点节点
     * 2. 反转链表后半部分
     * 3. 校验
     **/
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        // 找出中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 这个时候slow代表的就是后半部分的节点 反转它
        ListNode reverse = null;
        ListNode temp;
        while (slow != null) {
            temp = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = temp;
        }

        // 取出reverse和head对比
        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }

        return true;

    }

}
