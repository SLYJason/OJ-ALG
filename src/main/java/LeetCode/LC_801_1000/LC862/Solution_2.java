package LeetCode.LC_801_1000.LC862;

import java.util.ArrayDeque;
/**
 * Solution 2: monotonic queue
 */
public class Solution_2 {
    public int shortestSubarray(int[] A, int K) {
        int min_length = Integer.MAX_VALUE;
        int[] prefixSum = new int[A.length+1];
        // prefixSum[i] is prefix sum with length i.
        for(int i=1; i<prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }

        ArrayDeque<Integer> deque = new ArrayDeque();
        for(int i=0; i<prefixSum.length; i++) {
            // First loop is used to remove entry larger or equal to current prefixSum, i.e. keep deque monotonic increasing.
            while(!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.removeLast();
            }
            // Second loop is used to greedy to find the minimal subarray's length that its sum larger or equal to K.
            while(!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= K) {
                min_length = Math.min(min_length, i-deque.getFirst());
                deque.removeFirst();
            }
            deque.addLast(i);
        }
        return min_length == Integer.MAX_VALUE ? -1 : min_length;
    }
}
