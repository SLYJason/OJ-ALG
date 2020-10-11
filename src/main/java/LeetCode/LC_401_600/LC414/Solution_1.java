package LeetCode.LC_401_600.LC414;

/**
 * Solution 1: brute force, intuitive thought.
 */
public class Solution_1 {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE, second_max = Integer.MIN_VALUE, third_max = Integer.MIN_VALUE;
        boolean isFound = false;
        // get max value.
        for(int num : nums) max = Math.max(max, num);
        if(nums.length == 2) return max;
        // get second max value.
        for(int num : nums) {
            if(num != max) second_max = Math.max(second_max, num);
        }
        // get third max value.
        for(int num : nums) {
            if(num != max && num != second_max) {
                isFound = true;
                third_max = Math.max(third_max, num);
            }
        }
        return isFound ? third_max : max;
    }
}
