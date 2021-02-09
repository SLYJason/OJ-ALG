package LeetCode.LC_201_400.LC284;

import java.util.Iterator;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    class PeekingIterator implements Iterator<Integer> {
        Node head;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            head = new Node(0);
            Node cur = head;
            while(iterator.hasNext()) {
                Node node = new Node(iterator.next());
                cur.next = node;
                cur = node;
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return head.next.val;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(!hasNext()) return null;
            Node next = head.next;
            head.next = next.next;
            return next.val;
        }

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        class Node {
            public int val;
            public Node next;
            public Node(int val) {
                this.val = val;
            }
        }
    }
}
