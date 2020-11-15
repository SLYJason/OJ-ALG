package LeetCode.LC_1_200.LC16;

import java.util.Arrays;

/**
 * Solution: two pointers.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min_diff = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < Math.abs(min_diff)) {
                    min_diff = target - sum; // update min_diff.
                }
                if(sum == target) {
                    return target;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - min_diff;
    }
}
