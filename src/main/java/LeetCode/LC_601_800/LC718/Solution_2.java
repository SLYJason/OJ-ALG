package LeetCode.LC_601_800.LC718;

/**
 * Solution 2: DP.
 */
public class Solution_2 {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0, n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1]; // dp[i][j] means the longest common subarray between nums1 with length i and nums2 with length j, element in nums1[i-1] and nums2[j-1] must be included.
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
