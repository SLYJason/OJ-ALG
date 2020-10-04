package LeetCode.LC_201_400.LC268;

/**
 * Solution 2: XOR operator.
 */
public class Solution_2 {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i=0; i<nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
