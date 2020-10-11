package LeetCode.LC_201_400.LC347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution 1: using PriorityQueue.
 * Time Complexity: O(n log(n)), time complexity of PriorityQueue insertion of N elements is O(n log(n)).
 */
public class Solution_1 {
    public int[] topKFrequent(int[] nums, int k) {
        // step 1: count each number frequency
        Map<Integer, Integer> count = new HashMap();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        // step 2: building a PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)->(b.getValue() - a.getValue()));
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            pq.offer(entry);
        }
        // step 3: building the result
        int[] res = new int[k];
        int index = 0;
        while(index != k) {
            res[index++] = pq.poll().getKey();
        }
        return res;
    }
}
