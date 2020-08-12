package LeetCode.Design;

public class LeetCode622 {
    class MyCircularQueue {
        int[] queue;
        int head;
        int tail;
        int len;
        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            queue = new int[k];
            head = -1;
            tail = -1;
            len = 0;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if(isFull()) return false;
            // reset queue
            if(isEmpty()) {
                head = 0;
                tail = -1;
            }
            tail = (tail + 1) % queue.length;
            queue[tail] = value;
            len++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if(isEmpty()) return false;
            head = (head + 1) % queue.length;
            len--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return isEmpty() ? -1 : queue[head];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return isEmpty() ? -1 : queue[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return len == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return len == queue.length;
        }
    }
}
