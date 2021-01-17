package review.一月.linklist;

import leetcode.top100.simple.ListNode;

public class _206_反转链表 {


    public ListNode reverseList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }


        ListNode curryNode = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = curryNode;
            curryNode = head;
            head = nextNode;
        }

        return curryNode;
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后面进行排序
        int nums1Index = m -1;
        int nums2Index = n -1;
        int index = nums1.length -1 ;

        while(nums2Index >= 0) {
            // 先对nums1交换
            while (nums1Index >= 0  && nums1[nums1Index] > nums2[nums2Index]) {
                int tmp = nums1[index];
                nums1[index] = nums1[nums1Index];
                nums1[nums1Index] = tmp;
                index--;
                nums1Index--;
            }
            // 在对nums2 数据进行处理

            int tmp = nums1[index];
            nums1[index] = nums2[nums2Index];
            nums2[nums2Index] = tmp;
            nums2Index--;
            index--;
        }
    }


    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
