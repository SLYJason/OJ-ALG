package LeetCode.LC_1_200.LC45;

import java.util.Arrays;

/**
 * Solution 1: DP, using same logic in LC55 Solution_2.
 */
public class Solution_1 {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int[] dp = new int[nums.length]; // dp[i] means minimum steps reach i.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int end=1; end<nums.length; end++) {
            for(int start=0; start<end; start++) {
                if(start + nums[start] >= end) {
                    dp[end] = Math.min(dp[end], dp[start]+1);
                }
            }
        }
        return dp[nums.length-1] == Integer.MAX_VALUE ? -1 : dp[nums.length-1];
    }
}
