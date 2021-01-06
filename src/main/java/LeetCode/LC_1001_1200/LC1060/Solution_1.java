package LeetCode.LC_1001_1200.LC1060;

/**
 * Solution 1: linear search.
 */
public class Solution_1 {
    public int missingElement(int[] nums, int k) {
        if(nums.length == 1) return nums[0] + k;
        int missing = 0;
        for(int i=1; i<nums.length; i++) {
            missing += nums[i] - nums[i-1] - 1;
            if(missing >= k) {
                return (nums[i] - 1) - (missing - k);
            }
        }
        return nums[nums.length-1] + k - missing;
    }
}
