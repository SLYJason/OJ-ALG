package LeetCode.LC_1_200.LC146;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: optimal solution, put() & get() takes O(1) time.
 */
public class Solution_2 {
    class LRUCache {
        int capacity;
        Map<Integer, Node> map;
        Node head;
        Node tail;
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)) return -1;
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if(node == null) {
                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                map.put(key, newNode);
                addToHead(newNode);
                if(map.size() > capacity) {
                    map.remove(tail.prev.key);
                    removeTailNode();
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        // always add a node to the head.
        private void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

        // remove a node from the double linked list.
        private void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        // move a node to head.
        private void moveToHead(Node node){
            removeNode(node);
            addToHead(node);
        }

        // remove the tail node.
        private void removeTailNode() {
            Node prev = tail.prev;
            removeNode(prev);
        }
    }

    class Node {
        public int key;
        public int value;
        public Node prev;
        public Node next;
    }
}
