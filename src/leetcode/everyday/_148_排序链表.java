package leetcode.everyday;


/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 **/
public class _148_排序链表 {

    public static class ListNode {

        public int val;
        private ListNode head = null;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            head = this;
        }


        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }



        @Override
        public String toString() {
            if (head == null){
                return "[]";
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            ListNode temp = head;
            while (temp.next != null){
                sb.append(temp.val);
                sb.append(',');
                temp = temp.next;
            }
            sb.append(temp.val);
            sb.append(']');
            return sb.toString();
        }

    }


    /**
     * O(n log n) => 这个时间复杂度，能让我们联想到使用归并排序。可是归并排序的递归方式，则是要开辟O（n)的空间
     * 这个时候我们就应该使用迭代的方式，去实现这个算法。
     * 1. 归并是从底向上归并，这样的话，归并的结果就没问题的。
     * 我们应该先找到中点，而链表的中点应该使用，快慢指针去实现。
     * 2. 对于迭代的方式，我们应该按照步长，把其分为1、2、4、8等步长去进行迭代处理。
     **/
    public ListNode sortList(ListNode head) {
        // 边界判断
        if (head == null || head.next == null) {
            return head;
        }


        // 定义哨兵节点用于返回结果集合
        ListNode sentinelNode = new ListNode(-1);
        sentinelNode.next = head;

        // 获取节点的长度
        int length = getLength(head);

        // 使用迭代的方式代替递归
        for (int step = 1; step < length; step *= 2) {
            // 我们需要两个节点 prev cur；但是我们需要按块迭代的时候复原指向，所以都需要这个步骤
            ListNode prev = sentinelNode;
            ListNode curr = sentinelNode.next;

            // 按照步长进行迭代
            while (curr != null) {
                ListNode h1 = curr;
                // 找到步长内的第二部分节点数据
                ListNode h2 = spilt(h1, step);
                // 找到剩余的节点开头
                curr = spilt(h2, step);
                // 合并上述的两个链表
                prev.next = merge(h1, h2);
                //  找到末尾节点
                while (prev.next != null){
                    prev = prev.next;
                }
            }
        }
        return sentinelNode.next;
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode sentinelNode = new ListNode(-1);

        ListNode prevNode = sentinelNode;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                prevNode.next = h1;
                h1 = h1.next;
            } else {
                prevNode.next = h2;
                h2 = h2.next;
            }
            prevNode = prevNode.next;
        }
        if (h1 != null) {
            prevNode.next = h1;
        }
        if (h2 != null) {
            prevNode.next = h2;
        }
        return sentinelNode.next;
    }

    private ListNode spilt(ListNode node, int step) {
        if (node == null) {
            return null;
        }


        ListNode cur = node;

        //找到步长的后半部分节点
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode nextNode = cur.next;
        // 断掉前面的链表
        cur.next = null;

        return nextNode;
    }

    private int getLength(ListNode head) {
        int count = 1;
        ListNode tmp = head;
        while (tmp.next != null) {
            count++;
            tmp = tmp.next;

        }
        return count;
    }

    public static void main(String[] args) {
        _148_排序链表 test = new _148_排序链表();

        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(-1);
        ListNode head4 = new ListNode(4);
        head.setNext(head1);
        head1.setNext(head2);
        head2.setNext(head3);
        head3.setNext(head4);
        System.out.println(test.sortList(head));
    }
}
