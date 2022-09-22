package LeetCode.LC_601_800.LC641;

/**
 * Solution 1: array.
 */
public class Solution_1 {
    class MyCircularDeque {
        int[] queue;
        int head;
        int tail;
        int size;

        public MyCircularDeque(int k) {
            queue = new int[k];
            head = tail = -1;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            if (isEmpty()) { // reset the queue.
                head = 1;
                tail = 0;
            }
            head = head - 1 < 0 ? queue.length - 1 : head - 1;
            queue[head] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
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

        public boolean deleteFront() {
            if (isEmpty()) return false;
            head = (head + 1) % queue.length;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            tail = tail - 1 < 0 ? queue.length - 1 : tail - 1;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : queue[head];
        }

        public int getRear() {
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
