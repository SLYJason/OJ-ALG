package LeetCode.LC_1601_1800.LC1646;

class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0 || n == 1) return n;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 0;
        for(int i=2; i<n+1; i++) {
            if(i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else {
                nums[i] = nums[(i-1) / 2] + nums[(i-1) / 2 + 1];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
