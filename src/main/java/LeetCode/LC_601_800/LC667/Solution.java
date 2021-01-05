package LeetCode.LC_601_800.LC667;

/**
 * Solution: smart construction.
 */
public class Solution {
    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        if(k == 1) { // base case.
            for(int i=0; i<n; i++) nums[i] = i + 1;
            return nums;
        }
        int left = 1, right = n;
        for(int i=0; i<n; i++) {
            nums[i] = k % 2 == 0 ? left++ : right--;
            if(k > 1) k--;
        }
        return nums;
    }
}
