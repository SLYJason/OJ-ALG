package LeetCode.LC_601_800.LC622;

/**
 * Solution 1: array.
 */
public class Solution_1 {
    class MyCircularQueue {
        int[] queue;
        int head;
        int tail;
        int size;
        public MyCircularQueue(int k) {
            queue = new int[k];
            head = tail = -1;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            if (isEmpty()) { // reset the queue.
                head = 0;
                tail = -1;
            }
            tail = (tail + 1) % queue.length;
            queue[tail] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            head = (head + 1) % queue.length;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : queue[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : queue[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }
    }
}
