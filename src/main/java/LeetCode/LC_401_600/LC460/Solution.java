package LeetCode.LC_401_600.LC460;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Solution 1: HashMap + Double LinkedList. Very hard to come up with it in an interview.
 */
public class Solution {
    class LFUCache {
        int capacity;
        Map<Integer, Node> nodeMap; // K: key, V: node contains {key, value, frequency}.
        TreeMap<Integer, DLList> freqMap; // K: frequency, V: double linked list, using the logic in LRU cache.
        int size;
        int minFreq;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            nodeMap = new HashMap();
            freqMap = new TreeMap();
            size = 0;
            minFreq = 0;
        }

        public int get(int key) {
            if(!nodeMap.containsKey(key)) return -1;
            Node node = nodeMap.get(key);
            update(node);
            return node.value;
        }

        public void put(int key, int value) {
            if(capacity == 0) return;
            Node node;
            if(nodeMap.containsKey(key)) {
                node = nodeMap.get(key);
                node.value = value;
                update(node);
            } else {
                node = new Node(key, value);
                nodeMap.put(key, node);
                if(size == capacity) {
                    DLList minFreqList = freqMap.get(minFreq);
                    Node tailNode = minFreqList.removeTail();
                    nodeMap.remove(tailNode.key);
                    if(minFreqList.size == 0) freqMap.remove(minFreq);
                    size--;
                }
                size++;
                minFreq = 1; // reset minFreq to 1 because of adding new node.
                DLList nodeList = freqMap.getOrDefault(1, new DLList());
                nodeList.addToHead(node);
                freqMap.put(1, nodeList);
            }
        }

        // increase current node frequency, remove node from current DLList and append the node to a new DLList.
        private void update(Node node) {
            DLList oldDllist = freqMap.get(node.freq);
            oldDllist.removeNode(node);
            // if the node has the min frequency and is the last element in the minimum frequency list, should remove node frequency list and increase minimum frequency by 1.
            if(node.freq == minFreq && oldDllist.size == 0) {
                freqMap.remove(node.freq);
                minFreq++;
            }
            node.freq++;
            DLList newDllist = freqMap.getOrDefault(node.freq, new DLList());
            newDllist.addToHead(node);
            freqMap.put(node.freq, newDllist);
        }
    }

    class DLList {
        Node head;
        Node tail;
        int size;
        public DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // always add a node to the head.
        public void addToHead(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            size++;
        }

        // remove a node from the double linked list.
        public void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        // remove tail node.
        public Node removeTail() {
            if(size > 0) {
                Node tailNode = tail.prev;
                removeNode(tail.prev);
                return tailNode;
            }
            return null;
        }
    }

    class Node {
        public int key;
        public int value;
        public int freq;
        public Node prev;
        public Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
}
