package LeetCode.LC_201_400.LC209;

import java.util.TreeMap;

/**
 * Solution: prefixSum + TreeMap.
 */
public class Solution_1 {
    public int minSubArrayLen(int s, int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap();
        int min_length = Integer.MAX_VALUE;
        int prefixSum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            map.put(prefixSum, i);
            if(map.floorEntry(prefixSum-s) != null) {
                min_length = Math.min(min_length, i-map.floorEntry(prefixSum-s).getValue());
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}
