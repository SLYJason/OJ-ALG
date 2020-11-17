package LeetCode.LC_401_600.LC560;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: prefix sum.
 */
public class Solution_2 {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0, count = 0;
        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            if(prefixSum == k) count++;
            if(map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
