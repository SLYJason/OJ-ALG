package LeetCode.LC_1601_1800.LC1752;

/**
 * Solution: one pass.
 */
public class Solution {
    public boolean check(int[] nums) {
        int n = nums.length, k = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > nums[(i + 1) % n]) {
                k++;
            }
            if(k > 1) return false;
        }
        return true;
    }
}
