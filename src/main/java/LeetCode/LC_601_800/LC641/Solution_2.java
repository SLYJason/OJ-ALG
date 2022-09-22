package LeetCode.LC_601_800.LC641;

import Shared.DoubleListNode;

public class Solution_2 {
    class MyCircularDeque {
        int size, capacity;
        DoubleListNode head, tail;

        public MyCircularDeque(int k) {
            capacity = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            DoubleListNode node = new DoubleListNode(value);
            if (isEmpty()) {
                head = tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            DoubleListNode node = new DoubleListNode(value);
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            DoubleListNode next = head.next;
            if (next == null) {
                tail = null; // no node left, assign both head and tail to null.
            } else {
                next.prev = null;
                head.next = null;
                head = next;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            DoubleListNode prev = tail.prev;
            if (prev == null) {
                head = null; // no node left, assign both head and tail to null.
            } else {
                prev.next = null;
                tail.prev = null;
                tail = prev;
            }
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : head.value;
        }

        public int getRear() {
            return isEmpty() ? -1 : tail.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
