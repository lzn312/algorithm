package leetcode.top100.simple;
/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @see  leetcode.链表._206_反转链表
 **/
public class _206_反转链表 {
    /**
     * 这题以前做过 但是具体怎么做的忘了 只记得有印象做过
     * 开始我想的是使用stack来做
     * 但是时间复杂度O(m+n) -> m = n ->O(n)
     * 空间复杂度也是O(n)算法效率过低
     * 只能舔着脸回去看以前的解析了
     * 非递归版本
     **/
    public ListNode reverseList(ListNode head) {
        // 判定边界条件
        if (head == null || head.next == null) return head;
        /**
         * 这题的思路： 从head截取出当前节点,并将节点的next指向一个初始状态为null的节点
         *             更新head节点指向head.next节点完成置换
         *             时间复杂度: O（n)
         *             空间复杂度: O(1)
         **/
        // 定义一个初始状态为null的节点 该节点为最后输出结果
        ListNode replacementNode = null;
        // 记录一个临时节点用来存储下一个需要遍历的head节点
        ListNode temp;
        while (head != null){
            // 存储需要遍历的节点
            temp = head.next;
            // 这不就相当于 取出了head节点兵器把其指向了代替节点 则循环就相当于倒序
            head.next = replacementNode;
            // 赋值replace为当前head指向
            replacementNode = head;
            head = temp;
        }
        return replacementNode;
    }

}
