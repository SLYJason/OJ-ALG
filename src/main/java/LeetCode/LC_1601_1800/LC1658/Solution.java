package LeetCode.LC_1601_1800.LC1658;

import java.util.Arrays;

/**
 * Solution: sliding window.
 */
public class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int rest = Arrays.stream(nums).sum() - x;
        if(rest < 0) return -1; // base case 1.
        if(rest == 0) return n; // base case 2.
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        while(j < n) {
            sum += nums[j++];
            while(sum >= rest) {
                if(sum == rest) max = Math.max(max, j - i);
                sum -= nums[i++];
            }
        }
        return max == Integer.MIN_VALUE ? -1 : n - max;
    }
}
