package LeetCode.LC_1001_1200.LC1099;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Solution 1: no sorting.
 */
public class Solution_1 {
    public int twoSumLessThanK(int[] A, int K) {
        NavigableMap<Integer, Integer> map = new TreeMap(); // K: difference between num and K, V: index of num.
        int min_diff = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(A[i]+1); // need to get it's upper bound, so A[i] + 1.
            if(ceilingEntry != null) {
                int complement = ceilingEntry.getKey();
                int complement_idx = ceilingEntry.getValue();
                if(i > complement_idx) {
                    min_diff = Math.min(min_diff, complement - A[i]);
                }
            }
            map.put(K - A[i], i);
        }
        return min_diff == Integer.MAX_VALUE ? -1 : K - min_diff;
    }
}
