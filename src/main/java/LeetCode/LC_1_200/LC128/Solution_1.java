package LeetCode.LC_1_200.LC128;

import java.util.Arrays;

public class Solution_1 {
    /**
     * Solution 1: sorting + sliding window.
     * Refer: LC674.
     * Time Complexity: O(NlogN).
     * Space Complexity: O(1).
     */
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

    /**
     * Another implementation, using sorting not using sliding window.
     */
    public int longestConsecutive2(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int max = 1, max_so_far = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                max = Math.max(max, max_so_far);
            } else if(nums[i] - nums[i-1] == 1) {
                max_so_far++;
                max = Math.max(max, max_so_far);
            } else{
                max_so_far = 1;
            }
        }
        return max;
    }
}
