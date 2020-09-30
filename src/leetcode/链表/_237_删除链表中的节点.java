package leetcode.链表;
/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 **/
public class _237_删除链表中的节点 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    // 只给了需要删除的节点 我们能拿到删除节点的next节点。 把next节点的值覆盖掉当前节点 然后把当前next节点指向next.next节点就行
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
