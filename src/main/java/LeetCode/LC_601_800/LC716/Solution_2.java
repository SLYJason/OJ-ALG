package LeetCode.LC_601_800.LC716;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Solution 2: using TreeMap + DoubleLinkedList, same as LRU cache logic.
 */
public class Solution_2 {
    class MaxStack {
        TreeMap<Integer, List<ListNode>> map; // K: inserted x value, V: a list of Node has value x.
        DoubleLinkedList ddl; // simulation of the stack.
        /** initialize your data structure here. */
        public MaxStack() {
            map = new TreeMap();
            ddl = new DoubleLinkedList();
        }

        public void push(int x) {
            ListNode node = new ListNode(x);
            if(!map.containsKey(x)) map.put(x, new ArrayList());
            map.get(x).add(node);
            ddl.add(node);
        }

        public int pop() {
            ListNode top = ddl.pop(); // top of the stack (last element of DoubleLinkedList).
            ddl.remove(top);
            map.get(top.val).remove(top); // remove top from the map.
            if(map.get(top.val).size() == 0) map.remove(top.val); // if List is empty, remove the entry from the map.
            return top.val;
        }

        public int top() {
            return ddl.peek();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            List<ListNode> maxList = map.get(peekMax()); // a List of Node that has max value.
            ListNode max = maxList.get(maxList.size()-1);
            maxList.remove(max);
            if(maxList.size() == 0) map.remove(peekMax()); // if List is empty, remove the entry from the map.
            ddl.remove(max); // remove the max from the stack (DoubleLinkedList).
            return max.val;
        }

        class DoubleLinkedList {
            ListNode head; // bottom of the stack.
            ListNode tail; // top of the stack.

            public DoubleLinkedList() {
                head = new ListNode(0);
                tail = new ListNode(0);
                head.next = tail;
                tail.prev = head;
            }

            // remove the last(top) Node from the DoubleLinkedList.
            public ListNode pop() {
                ListNode top = tail.prev;
                remove(top);
                return top;
            }

            // get the last(top) Node val from the DoubleLinkedList.
            public int peek() {
                int top = tail.prev.val;
                return top;
            }

            public void add(ListNode node) {
                ListNode prev = tail.prev;
                prev.next = node;
                node.prev = prev;
                node.next = tail;
                tail.prev = node;
            }

            public void remove(ListNode node) {
                ListNode prev = node.prev;
                ListNode next = node.next;
                prev.next = next;
                next.prev = prev;
            }
        }

        class ListNode {
            public int val;
            public ListNode prev;
            public ListNode next;
            public ListNode(int val) {
                this.val = val;
            }
        }
    }
}
