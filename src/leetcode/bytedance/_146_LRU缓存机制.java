package leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

public class _146_LRU缓存机制 {




    class LRUCache {
        class Node{
            public int key,val;
            public Node prev;
            public Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }


        class DoubleList{
            private Node head;
            private Node tail;
            private int size;

            public DoubleList() {
                head = new Node(0,0);
                tail = new Node(0,0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void addLast(Node x) {
                x.prev = tail.prev;
                x.next = tail;
                tail.prev.next = x;
                tail.prev = x;
                size++;
            }


            public void remove(Node x) {
                x.prev.next = x.next;
                x.next.prev = x.prev;
                size--;
            }

            // 删除链表中第一个节点，并返回该节点，时间 O(1)
            public Node removeFirst() {
                if (head.next == tail) return null;

                Node first = head.next;
                remove(first);
                return first;
            }

            public int size() {
                return size;
            }


        }


        private Map<Integer, Node> map;

        private DoubleList cache;

        private int cap ;

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.map = new HashMap<>();
            this.cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key))
                return -1;
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                deleteKey(key);
                addRecently(key, value);
                return;
            }

            if (cap == cache.size) {
                removeLeastRecently();
            }

            addRecently(key, value);
        }

        private void makeRecently(int key) {
            Node x = map.get(key);
            cache.remove(x);
            cache.addLast(x);
        }

        private void addRecently(int key, int val) {
            Node newNode = new Node(key, val);
            cache.addLast(newNode);
            map.put(key, newNode);
        }


        private void deleteKey(int key) {
            Node x = map.get(key);
            map.remove(key);
            cache.remove(x);
        }


        private void removeLeastRecently() {
            Node node = cache.removeFirst();
            map.remove(node.key);
        }


        }
}
