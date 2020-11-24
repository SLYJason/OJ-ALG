package LeetCode.LC_201_400.LC325;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 1: prefixSum.
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int max_length = 0, prefixSum = 0;
        map.put(0, -1);
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            if(!map.containsKey(prefixSum)) map.put(prefixSum, i);
            if(map.containsKey(prefixSum - k)) {
                max_length = Math.max(max_length, i - map.get(prefixSum - k));
            }
        }
        return max_length;
    }
}