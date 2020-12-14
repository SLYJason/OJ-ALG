package LeetCode.LC_1_200.LC41;

/**
 * Solution 2: index as hash key.
 */
public class Solution_2 {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int n = nums.length;
        int INVALID = n + 1;
        // Step 1: data clean up.
        for(int i=0; i<n; i++) {
            if(nums[i] <= 0 || nums[i] > n) nums[i] = INVALID;
        }
        // Step 2: hashing.
        for(int i=0; i<n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(index < n) nums[index] = -Math.abs(nums[index]);
        }
        // Step 3: find the first missing positive number.
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) return i+1;
        }
        return n + 1;
    }
}
