package LeetCode.LC_201_400.LC300;

import java.util.Arrays;

/**
 * Solution: DP.
 * Time Complexity: O(n^2).
 * Space Complexity: O(n).
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
        }
        for(int i=0; i<f.length; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
