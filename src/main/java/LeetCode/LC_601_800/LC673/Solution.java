package LeetCode.LC_601_800.LC673;

import java.util.Arrays;

/**
 * Solution: DP.
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        int maxLength = 0, res = 0;
        int[] length = new int[nums.length]; // length of longest increasing subsequence at nums[i].
        int[] count = new int[nums.length]; // number of longest increasing subsequence at nums[i].
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        for(int i=1; i<l; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    if(length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } else if(length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, length[i]);
        }
        // build the result.
        for(int i=0; i<l; i++) {
            if(length[i] == maxLength) res += count[i];
        }
        return res;
    }
}
