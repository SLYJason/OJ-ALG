package LeetCode.LC_601_800.LC697;

import java.util.Map;
import java.util.HashMap;

/**
 * Solution 2: clean code solution.
 */
public class Solution_2 {
    public int findShortestSubArray(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        Map<Integer, Integer> count = new HashMap(); // count each num frequency.
        Map<Integer, Integer> first = new HashMap(); // count first index of each num.
        int degree = Integer.MIN_VALUE;
        int len = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(!first.containsKey(nums[i])) first.put(nums[i], i); // put the num first index.
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1); // update the num frequency.
            if(degree < count.get(nums[i])) { // find a new degree.
                degree = count.get(nums[i]);
                len = i - first.get(nums[i]) + 1;
            } else if(degree == count.get(nums[i])) { // found same degree, update the minimum length.
                len = Math.min(len, i - first.get(nums[i]) + 1);
            }
        }
        return len;
    }
}
