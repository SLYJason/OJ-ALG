package LeetCode.HashMap;

import java.util.Map;
import java.util.HashMap;

public class LeetCode560 {
    // Solution 1: initial thoughts, brute force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        for(int i=0; i<nums.length; i++) {
            int j=i, sum=0;
            while(j<nums.length) {
                sum += nums[j++];
                if (sum == k) {
                    total++;
                }
            }
        }
        return total;
    }

    // Solution 2: optimal solution using prefixSum, Map(prefixSum, # of occurrences of prefixSum).
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int subarraySum2(int[] nums, int k) {
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
