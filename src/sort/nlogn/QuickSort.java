package sort.nlogn;

import leetcode.everyday._148_排序链表;
import leetcode.top100.simple.ListNode;
import util.BaseUtil;

import java.util.Arrays;

/**
 * 快速排序
 * 用于数据量比较大
 * 但是当原数据接近有序亦或有序
 * 最坏时间复杂度可到O(sort.n²)
 * 平均时间复杂度为O(sort.nlogn)
 * 核心思想:
 * 和归并排序有不同
 * 快速排序是先排序然后在继续分类
 * 归并为先分类至下级在开始然后由下至上合并
 **/
public class QuickSort {
    public static void main(String[] args) {
//        int[] discorded = BaseUtil.randomIntArray(1000,100);
//        System.out.println(Arrays.toString(discorded));
//        quickSort(discorded, discorded.length - 1);
//        System.out.println(Arrays.toString(discorded));

        ListNode root = new ListNode(4);
        root.next = new ListNode(3);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(1);
        quickSortLinkList(root);

        System.out.println(root);
    }

    public static void quickSort(int[] discorded, int size) {
        if (size <=1)return;

        quickSortInternally(discorded,0 , size);
    }


    public static void quickSortLinkList(ListNode node) {
        if (node == null || node.next == null) return;

        quickSortInternallyLinkList(node, null);
    }

    private static void quickSortInternallyLinkList(ListNode start, ListNode end) {
        // base case
        if ( start == end || start.next == end) return;

        ListNode mid = pivotNode(start, end);
        quickSortInternallyLinkList(start, mid);
        quickSortInternallyLinkList(mid.next, end);
    }

    private static ListNode pivotNode(ListNode start, ListNode end) {

        ListNode indexNode = start;
        ListNode curNode = start.next;
        int baseVal = start.val;
        while (curNode != end) {
            // 如果当前节点比基准值小，放到他左边去
            if (curNode.val < baseVal) {
                indexNode = indexNode.next;
                swap(indexNode, curNode);
            }
            curNode = curNode.next;
        }

        // 最后交换其和index的值
        swap(indexNode, start);
        return indexNode;
    }

    private static void swap(ListNode indexNode, ListNode curNode) {
        int tmp = curNode.val;
        curNode.val = indexNode.val;
        indexNode.val = tmp;
    }

    /**
     * @param q 起点位置
     * @param r 终点位置
     * @param discorded 数组
     **/
    private static void quickSortInternally(int[] discorded, int q, int r) {
        //确定终止条件
        if (q >= r){
            return;
        }

        int p = pivot(discorded, q, r);

        quickSortInternally(discorded,q,p-1);
        quickSortInternally(discorded,p + 1, r);
    }


    /**
     * 进行端点确认
     * 端点应该选择排序完的位置
     **/
    private static int pivot(int[] discorded, int q, int r) {
        //确认端点
        int pivot = discorded[r] ;
        int index = q;
        //进行排序,默认交换
        for (int i = q; i <= r -1 ; i++){

            if (discorded[i] <= pivot){
                if (i == index){
                    ++index;
                }else {
                    int tmp = discorded[index];
                    discorded[index] = discorded[i];
                    discorded[i] = tmp;
                    index++;
                }
            }
        }
        //排序完成之后需要把端点放入中间 区分左边和右边
        //左边是排序完成的数据 右边是没有排序的数据
        int tmp = discorded[index];
        discorded[index] = pivot;
        discorded[r] = tmp;
        return index;
    }
}
