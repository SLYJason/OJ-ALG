package LeetCode.LC_2001_2200.LC2104;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
}
