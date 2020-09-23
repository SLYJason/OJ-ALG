package LeetCode.LC674;

/**
 * Solution 2: DP.
 */
public class Solution_2 {
    public int findLengthOfLCIS(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        int res = 1;
        int max_length = 1;
        for(int i=1; i<l; i++) {
            max_length = nums[i] > nums[i-1] ? max_length + 1 : 1;
            res = Math.max(res, max_length);
        }
        return res;
    }
}
