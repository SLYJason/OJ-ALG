package LeetCode.LC_601_800.LC697;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Solution 1: brute force, intuitive thoughts.
 */
public class Solution_1 {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        Map<Integer, Integer> map = new HashMap(); // count each num frequency.
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);

        int degree = Collections.max(map.values()); // array degree.

        Set<Integer> set = new HashSet(); // store the num that has the degree.
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == degree) set.add(entry.getKey());
        }

        int len = Integer.MAX_VALUE; // final results.
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                int count = 0, j = i;
                while(count != degree) {
                    if(nums[j] == nums[i]) count++;
                    j++;
                }
                len = Math.min(len, j-i);
                set.remove(nums[i]); // need to remove the num from the set.
            }
        }
        return len;
    }
}
