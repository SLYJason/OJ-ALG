package LeetCode.LC128;

import java.util.Arrays;
/**
 * Solution 1: sorting + sliding window.
 * Refer: LC674.
 * Time Complexity: O(NlogN).
 * Space Complexity: O(1).
 */
public class Solution_1 {
    public int longestConsecutive(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        Arrays.sort(nums);
        int res = 1, pivot = 0;
        for(int i=1; i<l; i++) {
            if(nums[i-1] == nums[i]) {
                pivot++;
            } else if(nums[i-1] + 1 == nums[i]) {
                res = Math.max(res, i-pivot+1);
            } else {
                pivot = i;
            }
        }
        return res;
    }
}
