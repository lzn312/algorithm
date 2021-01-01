package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

public class _146_ {
    static class LRUCache {
        private final Map<Integer, Node> readMap;
        private Node head = null;
        private Node tail = null;
        private final int size;

        public LRUCache(int capacity) {
            readMap = new HashMap<>(capacity);
            this.size = capacity;
        }

        public int get(int key) {
            Node currentNode = readMap.get(key);
            if (currentNode == null) {
                return -1;
            }
            if (head != currentNode) {


                // 调整当前Node节点数据
                Node currNextNode = currentNode.next;
                Node currPrevNode = currentNode.prev;
                // 如果时尾节点
                if (tail == currentNode) {
                    // 只处理前置节点就行了
                    currPrevNode.next = null;
                    tail = currPrevNode;
                } else {
                    currNextNode.prev = currPrevNode;
                    currPrevNode.next = currNextNode;
                }


                // 调整head节点数据
                currentNode.prev = null;
                currentNode.next = head;
                head = currentNode;


            }
            return currentNode.val;
        }

        public void put(int key, int value) {
            int oldVal = get(key);
            Node currNode;
            if (oldVal != -1) {
                currNode = readMap.get(key);
                currNode.val = value;
                return;
            }

            // 需要走淘汰策略
            if (readMap.size() == size) {
                // 移除末尾元素
                readMap.remove(tail.key);
                Node tailPrevNode = tail.prev;
                tailPrevNode.next = null;
                Node tailNode = tail;
                tail = tailPrevNode;
                tailNode.prev = null;
                tail = null;
            }

            currNode = new Node(key, value);
            readMap.put(key, currNode);

            if (tail == null && head == null) {
                tail = currNode;
                head = currNode;
            } else {
                // 获取head的next节点
                currNode.next = head;
                head.prev = currNode;
                head = currNode;
            }


        }

        private static class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

        }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
    }

    //["LRUCache","put","put","get","put","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int val = lruCache.get(1);
        lruCache.put(3,3);
        val = lruCache.get(2);
        lruCache.put(4,4);
        val = lruCache.get(1);
        val = lruCache.get(3);
        val = lruCache.get(4);
    }
}
