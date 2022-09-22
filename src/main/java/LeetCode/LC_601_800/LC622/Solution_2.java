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
            this.capacity = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            ListNode node = new ListNode(value);
            if (isEmpty()) {
                this.head = this.tail = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }
            this.size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            this.head = this.head.next;
            this.size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : this.head.val;
        }

        public int Rear() {
            return isEmpty() ? -1 : this.tail.val;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.capacity;
        }
    }
}
