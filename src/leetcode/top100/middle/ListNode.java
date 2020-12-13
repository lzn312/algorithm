package leetcode.top100.middle;

import java.util.Iterator;

public class ListNode {
    private int size;
    public int val;
    private  ListNode head  = null;
    public ListNode next;
    public ListNode(int x) {
        val = x;

    }

    public void setNext(ListNode next) {
        if (head == null){
            head = this;
        }
        this.next = next;
        size++;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode get(int index){
        int ind = 0;
        ListNode node  = head;
        while (ind != index){
            ind++;
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {

        Iterator<ListNode> it = iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int pos = 0;pos<10;pos++) {
            ListNode e = it.next();
            sb.append( e.val);
            if (! it.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
        return sb.toString();
    }

    private Iterator<ListNode> iterator() {
        return  new Itr();

    }

    private class Itr implements Iterator<ListNode> {
        private int cursor = 0;
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public ListNode next() {
            return get(cursor++);
        }
    }
}
