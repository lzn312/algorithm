package leetcode.链表;

import leetcode.top100.middle.ListNode;

/**
 * @author Leezer
 * @date 2020/10/19 9:42 上午
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 **/
public class _19_删除链表的倒数第N个节点 {

    /**
     * 看到这个题我的第一个想法是，把这个数组排序，然后在找到第n个节点，把它的后置节点删除，然后在反转回来就行了。
     * 这样的话时间复杂度为On,空间复杂度为O1.
     * 但是题目询问的是是否能通过一遍扫描完成，这就有点难度了.
     *
     * 在接触链表的时候，我们都要注意一个东西，叫哨兵节点，哨兵节点的作用就是帮助我们，
     *  - 附加在原链表最前面用来简化边界条件的附加节点，它的值域不存储任何东西，只是为了操作方便而引入。-
     *  他的作用就是在操作第一个元素的时候，也能不用注意处理边界条件。
     *
     *  这题一次遍历，我们可以使用快慢指针来实现。我们可以使快指针先走n步，这样，当快指针到达null的时候，慢指针所指的元素就是第n个元素。
     *  我们就可以对它进行操作了,但是这题是叫我们删除第N个元素，所以我们应该找到的是N的上一个元素来进行操作,所以我们可以是fast多块一步。
     **/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 设置哨兵节点
        ListNode sentinelNode = new ListNode(0, head);

        // fast多块一步
        ListNode fastNode = head;
        ListNode slowNode = sentinelNode;

        // 先走n步
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        // 两个一起走, 这里其实fast已经走了n步,while走的是剩下的L-n。步所以也是一次遍历
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = sentinelNode.next;
        }

        // 找到了要删除的节点
        slowNode.next = slowNode.next.next;
        return sentinelNode.next;
    }




}
