package LeetCode.LC_1601_1800.LC1753;

import java.util.Arrays;

/**
 * Solution 2: math.
 */
public class Solution_2 {
    public int maximumScore(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2]) {
            return nums[0] + nums[1];
        }
        return (nums[0] + nums[1] + nums[2]) / 2;
    }
}
