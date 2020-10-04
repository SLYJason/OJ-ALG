package LeetCode.LC_601_800.LC674;

/**
 * Solution 1: brute force.
 */
public class Solution_1 {
    public int findLengthOfLCIS(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        int res = 1;
        for(int i=1; i<l; i++) {
            int length = 1;
            for(int j=i; j<l; j++) {
                if(nums[j] > nums[j-1]) {
                    length++;
                } else {
                    break;
                }
            }
            res = Math.max(res, length);
        }
        return res;
    }
}
