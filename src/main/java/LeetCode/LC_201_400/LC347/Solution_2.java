package LeetCode.LC_201_400.LC347;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * Solution 3: bucket sort, optimal solution.
 * Time Complexity: O(n).
 */
public class Solution_2 {
    public int[] topKFrequent(int[] nums, int k) {
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
