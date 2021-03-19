package LeetCode.LC_201_400.LC376;

/**
 * Solution 1: 2D DP
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        int n = nums.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) dp[i] = new int[2];
        dp[0] = new int[]{1, 1};
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                int lenInc = dp[j][0], lenDec = dp[j][1];
                if(nums[i] > nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], lenDec + 1);
                } else if(nums[i] < nums[j]) {
                    dp[i][1] = Math.max(dp[i][1], lenInc + 1);
                } else {
                    dp[i][0] = lenInc;
                    dp[i][1] = lenDec;
                }
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
