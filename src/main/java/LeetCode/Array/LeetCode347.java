package LeetCode.Array;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode347 {
    /**
     * Solution 1: brute force, using TreeMap.
     * Time Complexity: O(n log(n)).
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        // step 1: count each number frequency
        Map<Integer, Integer> count = new HashMap();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        // step 2: sort the number by its frequency in descending order
        Map<Integer, List<Integer>> freq = new TreeMap(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if(freq.containsKey(entry.getValue())) {
                freq.get(frequency).add(num);
            } else{
                freq.put(frequency, new LinkedList<Integer>(){
                    {
                        add(num);
                    }
                });
            }
        }
        // step 3: build the result
        int index = 0;
        for(Map.Entry<Integer, List<Integer>> entry : freq.entrySet()) {
            List<Integer> list = entry.getValue();
            for(int num : list) {
                res[index++] = num;
            }
            if(index == k) break;
        }
        return res;
    }

    /**
     * Solution 2: using PriorityQueue.
     * Time Complexity: O(n log(n)).
     */
    public int[] topKFrequent2(int[] nums, int k) {
        // step 1: count each number frequency
        Map<Integer, Integer> count = new HashMap();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        // step 2: building a PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));
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

    /**
     * Solution 3: bucket sort, optimal solution.
     * Time Complexity: O(n).
     */
    public int[] topKFrequent3(int[] nums, int k) {
        // step 1: count each number frequency
        Map<Integer, Integer> count = new HashMap();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        // step 2: building a bucket, the index is frequencies of each num
        List<Integer>[] bucket = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int fre = entry.getValue();
            if(bucket[fre] == null) {
                bucket[fre] = new LinkedList();
            }
            bucket[fre].add(num);
        }
        // step 3: building the result
        int[] res = new int[k];
        int index = 0;
        for(int i=bucket.length-1; i>=0 && index<k; i--) {
            if(bucket[i] != null) {
                for(int num : bucket[i]) {
                    res[index++] = num;
                }
            }
        }
        return res;
    }
}
