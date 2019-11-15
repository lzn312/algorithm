package leetcode.top100.simple;
/**
 *给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * https://leetcode-cn.com/problems/linked-list-cycle
 * @see leetcode.链表._141_环形链表
 **/
public class _141_环形链表 {
    /**
     * 思路是应该使用快慢指针来做
     * 就像环形跑道跑步一样
     **/
    public boolean hasCycle(ListNode head) {
        if (head== null || head.next == null){
            return false;
        }
        ListNode slow = head;
        // 快的在前面先跑
        ListNode fast = head.next;
        // fast == null 说明它已经通关了 不可能存在环形了 因为一次跑两步 所以也需要考虑fast.next 不能为空
        while (slow != null && fast !=null && fast.next != null){
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
