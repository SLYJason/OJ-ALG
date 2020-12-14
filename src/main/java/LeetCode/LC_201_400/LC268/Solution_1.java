package LeetCode.LC_201_400.LC268;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<=nums.length; i++) sum += i;
        for(int n : nums) sum -= n;
        return sum;
    }
}
