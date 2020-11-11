package LeetCode.LC_1_200.LC55;

public class Solution_2 {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        boolean[] dp = new boolean[nums.length]; // dp[i] means position can be reached or not.
        dp[0] = true; // base case.
        for(int end=1; end<nums.length; end++) {
            for(int start=0; start<end; start++) {
                if(dp[start] && start + nums[start] >= end) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
