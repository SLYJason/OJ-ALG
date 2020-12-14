package LeetCode.LC_201_400.LC268;

/**
 * Solution 2: bit manipulation.
 */
public class Solution_2 {
    public int missingNumber(int[] nums) {
        int missing = 0;
        for(int i=0; i<nums.length; i++) {
            missing ^= (i + 1) ^ nums[i];
        }
        return missing;
    }
}
