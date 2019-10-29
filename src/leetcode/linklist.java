package leetcode;
/**
 * @author Leezer
 * @date 2019-05-17
 * 链表相关题目
 **/
public class linklist {

    protected class Node{
        Node pre,next;
        Object data;
        Node(Node pre, Node next, Object d){
            this.pre  = pre;
            this.next = next;
            this.data = d;
        }
    }


    /**
     * 1.单链表反转
     * 单链表反转的逻辑:
     * [data1][next] -> [data2][next] -> [data3][next]
     * [data3][next] -> [data2][next] -> [data1][next]
     * 逻辑:
     * 1.找到当前节点的下一个结点保存为一个node(next),得到的next结点就为去掉上一个结点的结点
     * 2.将当前节点的下一个结点设置为上一个结点
     * 3.将定义上一个节点的结点prev设置为当前结点
     * 4.将当前节点设置为next
     * 5.当循环到最后一个节点后,将节点赋值给head,完成反转
     **/
    private static Node reverse(Node p){
        if (p == null){
            return null;
        }else {
            Node head = null;//定义一个头结点
            Node pre = null;//定义一个前置节点
            Node current = p;
            while (current != null){
                Node next = current.next;//定义next为当前节点的第二个节点
                if (next == null ){
                    head = current;
                }
                current.next = pre;
                pre = current;
                current = next;
            }
            return head;
        }
    }





    /**
     * 2.链表中环的检测
     * 现象:             [data4][next]
     *                         |       ↖
     *                         v
     * [data1][next] -> [data2][next] -> [data3][next]
     *
     * 逻辑:
     * 使用快慢指针来进行判断.
     * 如果存在快慢指针相等时就有环
     **/
    private static boolean haveLoop(Node p){
        if (p != null){
            Node fast = p.next; //快指针定义下一个指针
            Node slow = p; //慢指针定义为当前指针

            //fast不为null 和 fast下一节点不为null 为null就不可能存在环
            while (fast != null && fast.next != null){
                if (fast == slow) return true;

                fast = fast.next.next;
                slow = slow.next;
            }

        }
        return false;
    }

}
