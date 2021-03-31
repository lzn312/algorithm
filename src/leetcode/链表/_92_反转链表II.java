package leetcode.链表;

import leetcode.top100.simple.ListNode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _92_反转链表II {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next ==  null ) return  head;

        if ( left == right) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        for (int i = 0; i < left - 1   ; i++) {
            preNode = preNode.next;
        }
        ListNode prev = preNode.next;
        ListNode tail = prev;
        ListNode cur = prev;

        // 头插法
        for (int i = 0; i <= right - left; i++) {
            ListNode next = cur.next;
            tail.next = next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        preNode.next = prev;
        return dummy.next;
    }


    public static void main(String[] args) throws InterruptedException {
//        _92_反转链表II test = new _92_反转链表II();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next= new ListNode(3);
//        head.next.next.next= new ListNode(4);
//        head.next.next.next.next= new ListNode(5);
//        System.out.println(test.reverseBetween(head,2,4));

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Condition condition1 = lock.newCondition();

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000));
                System.out.println(Thread.currentThread().getName() + "准备等待...."+ System.currentTimeMillis());
                condition.await();

                System.out.println(Thread.currentThread().getName() + "等待结束准备解锁...."+ System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });



        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(3000));
                System.out.println(Thread.currentThread().getName() + "准备通知...."+ System.currentTimeMillis());
                condition1.signal();
                System.out.println(Thread.currentThread().getName() + "通知完成...."+ System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                try {
                    Thread.sleep(10 * 1000);
                    System.out.println(Thread.currentThread().getName() + "等待结束准备解锁...." + System.currentTimeMillis());
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }


}
