package LeetCode.LC674;

/**
 * Solution: sliding window.
 */
public class Solution_3 {
    public int findLengthOfLCIS(int[] nums) {
        int l = nums.length;
        if(l <= 1) return l;
        int res = 1, pivot = 0;
        for(int i=1; i<l; i++) {
            if(nums[i-1] >= nums[i]) {
                pivot = i;
            } else {
                res = Math.max(res, i-pivot+1);
            }
        }
        return res;
    }
}
