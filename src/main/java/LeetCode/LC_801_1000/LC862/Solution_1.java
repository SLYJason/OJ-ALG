package LeetCode.LC_801_1000.LC862;

import java.util.TreeMap;

/**
 * Solution 1: prefixSum + TreeMap.
 */
public class Solution_1 {
    public int shortestSubarray(int[] A, int K) {
        int min_length = Integer.MAX_VALUE, prefixSum = 0;
        TreeMap<Integer, Integer> map = new TreeMap();
        map.put(0, -1);
        for(int i=0; i<A.length; i++) {
            prefixSum += A[i];
            if(map.floorEntry(prefixSum - K) != null) {
                min_length = Math.min(min_length, i-map.floorEntry(prefixSum - K).getValue());
            }
            while (map.size() > 0 && map.lastKey() > prefixSum) map.pollLastEntry(); // remove entries.
            map.put(prefixSum, i);
        }
        return min_length == Integer.MAX_VALUE ? -1 : min_length;
    }
}
