package LeetCode.LC_601_800.LC622;


import Shared.ListNode;

/**
 * Solution 2: singly linked list.
 */
public class Solution_2 {
    class MyCircularQueue {
        int size, capacity;
        ListNode head, tail;

        public MyCircularQueue(int k) {
            capacity = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = head.next;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : head.val;
        }

        public int Rear() {
            return isEmpty() ? -1 : tail.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }
}
