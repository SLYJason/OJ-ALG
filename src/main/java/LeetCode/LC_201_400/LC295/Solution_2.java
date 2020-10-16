package LeetCode.LC_201_400.LC295;

import java.util.PriorityQueue;

/**
 * Solution 2: using two heap.
 */
public class Solution_2 {
    class MedianFinder {
        int size = 0;
        PriorityQueue<Integer> maxHeap; // left half.
        PriorityQueue<Integer> minHeap; // right half.
        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
            minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        }

        public void addNum(int num) {
            if(size == 0) {
                maxHeap.offer(num);
                size++;
                return;
            }
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            // balance the queue.
            if(maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            size++;
        }

        public double findMedian() {
            if(size % 2 != 0) return (double)maxHeap.peek();
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
