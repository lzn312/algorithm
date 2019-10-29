package leetcode.top100.simple;
/**
 *将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 **/
public class _21_合并两个有序链表 {

    // TODO 暂时没写完 先放弃
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 第一想法合并两个有序链表使用计数排序但好像比较麻烦。
         **/
        int maxLength = -1;
        ListNode lTemp = l1;
        while (lTemp != null){
           if (lTemp.val > maxLength){
               maxLength = lTemp.val;
           }
            lTemp =lTemp.next;
        }
        lTemp = l2;
        while (lTemp != null){
            if (lTemp.val > maxLength){
                maxLength = lTemp.val;
            }
            lTemp =lTemp.next;
        }
        int[] count = new int[maxLength];
        return null;
    }

     public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
         if (l1 == null) {
             return  l2;
         }else if (l2 == null){
             return  l1;
         }

         // 使用prehead是为了定位prehead的初始标记
         final ListNode prehead = new ListNode(-1);
         ListNode prev = prehead;


         // 确定退出条件 (当l1和l2都不为空时)
         while ( l1!= null && l2 != null){
             if (l1.val < l2.val){
                 prev.next = l1;
                 l1 = l1.next;
             }else {
                 prev.next = l2;
                 l2 = l2.next;
             }
             prev = prev.next;
         }
         if (l1 != null) prev.next = l1;
         if (l2 != null )prev.next = l2;
         return prehead.next;
     }

    public static void main(String[] args) {
        /**
         *
         * 输入：1->2->4, 1->3->4
         * 输出：1->1->2->3->4->4
         **/
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(3);
         l1.next = l11;
         l1.next.next = l12;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l2.next.next = l22;
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(mergeTwoLists1(l1,l2));

    }
}
