package LeetCode.Design;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: optimal solution, put() & get() takes O(1) time.
 */
public class LeetCode146_Sol2 {
    class LRUCache {
        Map<Integer, DoubleLinkedNode> cache;
        int capacity;
        DoubleLinkedNode head;
        DoubleLinkedNode tail;

        public LRUCache(int capacity) {
            cache = new HashMap();
            this.capacity = capacity;
            head = new DoubleLinkedNode();
            tail = new DoubleLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;
            DoubleLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DoubleLinkedNode node = cache.get(key);
            if(node == null) {
                DoubleLinkedNode newNode = new DoubleLinkedNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key, newNode);
                addNode(newNode);
                if(cache.size() > capacity) {
                    DoubleLinkedNode tailNode = removeTailNode();
                    cache.remove(tailNode.key);
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        class DoubleLinkedNode {
            public int key;
            public int value;
            public DoubleLinkedNode prev;
            public DoubleLinkedNode next;
        }

        // always add node right after the head
        public void addNode(DoubleLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        // remove an existing node from the list
        public void removeNode(DoubleLinkedNode node) {
            DoubleLinkedNode prev = node.prev;
            DoubleLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        // move an node right after the head
        public void moveToHead(DoubleLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        // remove the tail node and return it
        public DoubleLinkedNode removeTailNode() {
            DoubleLinkedNode tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }
}
