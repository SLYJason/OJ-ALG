package LeetCode.LC_401_600.LC581;

import java.util.Arrays;

/**
 * Solution 1: sorting.
 */
public class Solution_1 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);
        int i = 0, j = n - 1;
        while(i < n && sorted[i] == nums[i]) i++;
        while(j > i && sorted[j] == nums[j]) j--;
        return j - i + 1;
    }
}
