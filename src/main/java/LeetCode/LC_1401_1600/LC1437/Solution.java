package LeetCode.LC_1401_1600.LC1437;

/**
 * Solution: one pass.
 */
public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int dist = k; // trick: initialize dist to k so we can pass the first 1 in nums.
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                if(dist < k) return false;
                dist = 0;
            } else {
                dist++;
            }
        }
        return true;
    }
}
